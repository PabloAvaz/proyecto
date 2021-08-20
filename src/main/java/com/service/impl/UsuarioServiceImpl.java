package com.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.domain.entity.acciones.AccionEquipable;
import com.domain.entity.producto.ProductoUsuario;
import com.domain.entity.producto.ProductoUsuarioId;
import com.domain.entity.user.Daily;
import com.domain.entity.user.Usuario;
import com.domain.repository.AccionEquipableRepository;
import com.domain.repository.DailyRepository;
import com.domain.repository.ProductoUsuarioRepository;
import com.domain.repository.UsuarioRepository;
import com.dto.acciones.EfectoDto;
import com.dto.producto.ProductoDto;
import com.dto.producto.ProductoUsuarioDto;
import com.dto.user.UsuarioDto;
import com.enums.Tipo;
import com.mapper.producto.ProductoMapper;
import com.mapper.producto.ProductoUsuarioMapper;
import com.mapper.user.PerfilMapper;
import com.mapper.user.UsuarioMapper;
import com.service.IEnergiaService;
import com.service.IPerfilService;
import com.service.IRestaurarService;
import com.service.IUsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {
	@Value("${daily.puntos}")
	private int puntosDaily; 
	private final UsuarioRepository repoUsuarios;
	private final ProductoUsuarioRepository repoProductoUsuario;
	private final AccionEquipableRepository repoAccionEquipable;
	private final DailyRepository repoDaily;
	private final PasswordEncoder passwordEncoder;
	private final IPerfilService servicePerfil;
	private final UsuarioMapper usuarioMapper;
	private final PerfilMapper perfilMapper;
	private final ProductoMapper productoMapper;
	private final ProductoUsuarioMapper productoUsuarioMapper;
	private final IEnergiaService energiaService;

	@Override
	public List<UsuarioDto> getAll() {
		return usuarioMapper.toDtoList(repoUsuarios.findAll());
	}

	@Override
	public Page<UsuarioDto> getAll(Pageable page) {
		return repoUsuarios.findAll(page).map(usuarioMapper::toDto);
	}

	@Override
	public UsuarioDto getById(Integer id) {
		Optional<Usuario> user = repoUsuarios.findById(id);
		return user.isPresent() ? usuarioMapper.toDto(user.get()) : null;
	}

	@Override
	public UsuarioDto getByUserName(String username) {
		Optional<Usuario> user = repoUsuarios.findByUsername(username);
		return user.isPresent() ? usuarioMapper.toDto(user.get()) : null;
	}
	@Override
	public void crear(UsuarioDto user) {
		user.agregarPerfil(perfilMapper.toDto(servicePerfil.getPerfil(2)));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setSkin(null);
		user.setEstatus(false);
		guardar(user);

		repoDaily.save(new Daily(getByUserName(user.getUsername()).getId(),0,0,false));
	}

	@Override
	public void guardar(UsuarioDto user) {
		repoUsuarios.save(usuarioMapper.toEntity(user));
	}

	@Override
	public void borrar(UsuarioDto user) {
		repoDaily.deleteById(user.getId());
		repoUsuarios.deleteById(user.getId());
	}

	@Override
	public void modificar(UsuarioDto user) {
		Optional<Usuario> tmp = repoUsuarios.findById(user.getId());

		if(tmp.isPresent()) {
			Usuario userFinal = usuarioMapper.merge(user, tmp.get());
			repoUsuarios.saveAndFlush(userFinal);
		}
	}

	@Override
	public void punto(UsuarioDto user) {
		user.anotar();
		Optional<Usuario> tmp = repoUsuarios.findById(user.getId());
		if (tmp.isPresent()) {
			Usuario userFinal = tmp.get();
			userFinal.setPuntos(user.getPuntos());
			userFinal.setTotal(user.getTotal());
			repoUsuarios.save(userFinal);
		}
	}

	@Override
	public UsuarioDto validar(UsuarioDto user) {
		Optional<Usuario> tmp =  repoUsuarios.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return tmp.isPresent() ? usuarioMapper.toDto(tmp.get()) : null;
	}

	@Override
	@Transactional
	public boolean comprar(UsuarioDto user, ProductoDto prod, Integer cantidad) {

		cantidad = cantidad != null && !prod.getTipo().equals(Tipo.EQUIPABLE) ? cantidad : 1;

		if(prod != null && user.getPuntos() >= prod.getPrecio() * cantidad) {

			if(!user.getArticulos().contains(prod)) {
				ProductoUsuario pru = new ProductoUsuario(new ProductoUsuarioId(productoMapper.toEntity(prod),usuarioMapper.toEntity(user)), cantidad);
				repoProductoUsuario.save(pru);
			} else if(!prod.getTipo().equals(Tipo.EQUIPABLE)) {
				ProductoUsuario prodUsr = repoProductoUsuario.findById(new ProductoUsuarioId(productoMapper.toEntity(prod),usuarioMapper.toEntity(user))).get();
				prodUsr.aumentarCantidad(cantidad);
				repoProductoUsuario.save(prodUsr);
			}

			user.gastar(prod.getPrecio() * cantidad);
			actualizarPuntos(user);

			return true;

		} else {
			return false;
		}
	}

	@Override
	@Transactional
	public void actualizarPuntos(UsuarioDto user) {
		repoUsuarios.gastarPuntos(user);
	}

	@Override
	public boolean usar(UsuarioDto user, ProductoDto producto, Integer cantidad) {
		switch(producto.getTipo()) {
		case CONSUMIBLE:
			Optional<ProductoUsuario> pu = repoProductoUsuario.findById(new ProductoUsuarioId(productoMapper.toEntity(producto), usuarioMapper.toEntity(user)));
			if(pu!=null) {
				ProductoUsuario puFinal = pu.get();
				puFinal = repoProductoUsuario.findById(new ProductoUsuarioId(productoMapper.toEntity(producto), usuarioMapper.toEntity(user))).get();

				
				if(puFinal.getCantidad() - cantidad >= 0) {
					//TODO PVS USAR OBJETO EFECTOS
					for (int veces = 0; veces < cantidad; veces++) {
						for (EfectoDto efecto : producto.getEfectos()) {
							switch(efecto.getTipo()) {
							case RECARGAR:
								user.getEnergia().recargar(efecto.getPoder());
								energiaService.modificar(user.getEnergia());
								break;
							case GASTAR:
								user.getEnergia().gastar(efecto.getPoder());
								energiaService.modificar(user.getEnergia());
								break;
							default: 
								System.out.println("Efecto no valido");
							}
						}
					}
					
					puFinal.disminuirCantidad(cantidad);
					repoProductoUsuario.save(puFinal);

					return true;
				}
			}
			break;

		case EQUIPABLE:
			Optional<AccionEquipable> accion = repoAccionEquipable.findById(producto.getId());
			Optional<Usuario> optionalUsuario = repoUsuarios.findById(user.getId());

			if(accion.isPresent() && optionalUsuario.isPresent()) {
				Usuario usuarioActualizado = optionalUsuario.get();
				usuarioActualizado.setSkin(accion.get().getSkin());
				repoUsuarios.save(usuarioActualizado);
				return true;
			}
			break;
		default:
			System.out.println("Tipo de producto no válido");
		}
		return false;
	}

	@Override
	public List<ProductoUsuarioDto> getProductos(UsuarioDto user) {
		return productoUsuarioMapper.toDtoList(repoProductoUsuario.findByUsuario(user.getId()));
	}

	@Override
	public boolean reclamarDaily(UsuarioDto user) {
		Daily daily;

		try {
			daily = repoDaily.findById(user.getId()).get();
		} catch (NoSuchElementException e) {
			daily = new Daily(user.getId(),0,0,false);
			repoDaily.save(daily);
		}

		if(!daily.isReclamado()) {
			user.darPuntos(puntosDaily);
			guardar(user);
			daily.reclamar();
			repoDaily.save(daily);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void reiniciarDaily() {
		repoDaily.reset();
	}

	@Override
	public Boolean existe(UsuarioDto user) {
		return repoUsuarios.findByUsernameOrEmail(user.getUsername(), user.getEmail()).isPresent();
	}

	@Override
	public UsuarioDto getByEmail(String email) {
		return usuarioMapper.toDto(repoUsuarios.findByEmail(email));
	}


}
