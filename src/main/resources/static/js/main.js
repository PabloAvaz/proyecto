$(window).on('load',function(){
	
	//Funcion para desplegar el menu de hamburguesa
	$(".hamburguesa").on('click', function(){
		$('nav').toggleClass('expandido')
	})
	
	//Funcion para hacer el header sticky
	$(document).on("scroll", (e) =>
		window.scrollY != 0
		? $("header").addClass("sticky")
		: $("header").removeClass("sticky")
	);
	  
	//Funcion para mostrar una modal
	  $('*[data-toggle]').on('click', function (e){
	  	const modal = $(e.target).data('toggle');
	        $(".modal-content").removeClass("a-subir")
	        $(".modal-content").addClass("a-bajar")
	  		$(modal).removeClass('oculto');
			$(modal).trigger('mostrar');
	  })
  
	//Funcion para ocultar una modal
	 $(".modal, .close, #modal-cancelar").on("click", () => {
		$(".modal-content").removeClass("a-bajar");
		$(".modal-content").addClass("a-subir")
		
		this.setTimeout(function(){ 
			$('.modal').addClass("oculto");
		}, 100)
	
	});

    $(".modal-content").on("click", (evt) => {
        evt.stopPropagation()
    })


	//Funcion para borrar alerts al hacerles click
	$('.alert').on('click', function(e){
		const target = $(e.target);
		if(target.is('div')) {
			target.remove()
		} else {
			target.parent().remove()	
		}
	})
	
	//Funcion para poner rojos campos con errores
	$(".form-grupo .form-error").parent().find(".form-campo").addClass("error")
})

	