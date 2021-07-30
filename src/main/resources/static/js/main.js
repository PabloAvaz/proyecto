/*
class ColeccionElementos extends Array {
    on = (evt, cb) => {
        this.forEach((elem) => elem.addEventListener(evt, cb));
    };
    text = (texto) => {
        this.forEach(elem => elem.textContent = texto);
    }
    removeClass = (clase) => {
        this.forEach((elem) => elem.classList.remove(clase));
    };
    addClass = (clase) => {
        this.forEach((elem) => elem.classList.add(clase));
    };
    toggleClass = (clase) => {
        this.forEach((elem) => elem.classList.contains(clase) ? this.removeClass(clase) : this.addClass(clase));
    }
    get = (index) => {
        return $(this[index]);
    };
    each = (call) => {
        this.forEach((elem) => call($(elem)));
    };
    show = () => {
        this.removeClass("oculto");
    };
    hide = () => {
        this.addClass("oculto");
    };
    toggle = () => {
        this.toggleClass("oculto");
    };
    enable = () => {
        this.forEach(elem => elem.disabled = false)
    }
    disable = () => {
        this.forEach(elem => elem.disabled = true)
    }
    data = function(attr, val = null) {
        if (val == null) {
            return this.length >= 1 ? this[0].dataset[attr] : null;
        } else {
            this.forEach(elem => elem.dataset[attr] = val);
        }
    }
}

const $ = (dir) =>
    typeof dir === "string" ?
    new ColeccionElementos(...document.querySelectorAll(dir)) :
    new ColeccionElementos(dir);
    */


$(window).on('load',function(){
  $(document).on("scroll", (e) =>
    window.scrollY != 0
      ? $("header").addClass("sticky")
      : $("header").removeClass("sticky")
  );
  
  $('*[data-toggle]').on('click', function (e){
  	const modal = $(e.target).data('toggle');
        $(".modal-content").removeClass("a-subir")
        $(".modal-content").addClass("a-bajar")
  		$(modal).removeClass('oculto');
  })
  
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
})

$("#clicker").on('click', function() {
	alert('ola')
})
