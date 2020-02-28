$(document).ready(function() {
	
	var menuItemWrappers = $('div[id$="menuItemWrapper"]');
	var menuPanels = $('div#menuBar div[id$=menuPanel]');
	var menuItems = menuItemWrappers.children('.rpfMenuItem');
	
	menuPanels.startTimeout = function() {
		console.log('start Timeout');
		menuPanels.hideTimeout = setTimeout(
				function() {
					menuPanels.slideUp(200);
					menuPanels
							.removeClass('menu-active-state')
				}, 1000);
	}
	
	menuPanels.stopTimeout = function stopTimeout() {
		console.log('stop Timeout');
		clearTimeout(this.hideTimeout);
	}
	
	menuItems.on( 'keyup mouseenter focus',	function(e) {
		var panel = $(this).siblings('div[id$=menuPanel]');
		menuPanels.stopTimeout();
		if (e.which == $.ui.keyCode.SPACE || e.which == $.ui.keyCode.ENTER || e.type == "mouseenter" || e.type == "focus") {
			if (menuPanels.is(':visible')) {
				panel.show();
				menuPanels.not('[id="' + panel.attr('id')+ '"]').hide();
			} else {
				panel.slideDown(200);
			}
		}	
		
		if (e.which == $.ui.keyCode.ESCAPE && menuPanels.is(':visible')) {
				panel.slideUp(100);
		}
		
	});
	
	menuItems.on('mouseleave', function(e) {
		menuPanels.stopTimeout();
		menuPanels.startTimeout();
	});
	
	menuItems.on('keyup click', function(e) {
		var panel = $(this).siblings('div[id$=menuPanel]');
		console.log(e.which)
		if (e.which == $.ui.keyCode.ENTER || e.type == "click" ) {
			$('.rpfMenuItem').removeClass('menu-active-state');
			$(this).addClass('menu-active-state');
			e.preventDefault();
			e.stopPropagation();
		}
	});
	
	menuPanels.on('mouseenter', function() {
		$(this).stop(true, false).slideDown(0);
		menuPanels.stopTimeout();
	});
	
	menuPanels.on('mouseleave keyup', function(e) {
		if (e.which == $.ui.keyCode.ESCAPE) {
			if ($(this).is(':visible'))
				$(this).slideUp(100);
		}
		if (e.type == "mouseleave" && !$(this).siblings('[id$=":hover"]')[0]) {
			menuPanels.stopTimeout();
			menuPanels.startTimeout();
		}
	});
	
	$(document).on('click',	function(e) {
		if (menuPanels.is(':visible') && !(menuPanels.filter(e.target) || menuPanels.find(e.target))) {
			menuPanels.slideUp(200);
		}
	});

});