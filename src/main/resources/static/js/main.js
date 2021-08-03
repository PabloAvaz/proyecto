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


	$(".hamburguesa").on('click', function(){
		$('nav').toggleClass('expandido')
	})
	
	$('.alert').on('click', function(e){
		const target = $(e.target);
		if(target.is('div')) {
			target.remove()
		} else {
			target.parent().remove()	
		}
	})
})

	