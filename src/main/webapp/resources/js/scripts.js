$(function() {

	var box = null;

	/* Box */
	$('[data-box]').live('click', function() {
		if($('#box-'+$(this).data('box')).length > 0) {
			var content = $('#box-'+$(this).data('box')).html();
			var boxWidth = $(this).data('width') || 300;
			var marginLeft = (boxWidth/2);
			if($(this).attr('id') != box) {
				var position = $(this).offset();
				var height = $(this).height();
				$('#box').attr('data-action', $(this).data('box')).html(content).css({
					top: position.top+height+'px',
					left: position.left-marginLeft+'px',
					width: boxWidth
				}).fadeIn();
				$('#black').fadeIn();
				box = $(this).attr('id');
			} else {
				if($('#box').is(':hidden')) {
					var position = $(this).offset();
					var height = $(this).height();
					$('#box').attr('data-action', $(this).data('box')).html(content).css({
						top: position.top+height+'px',
						left: position.left-marginLeft+'px',
						width: boxWidth
					}).fadeIn();
					$('#black').fadeIn();
					box = $(this).attr('id');
				} else {
					$('#black, #box').stop(true, true);
					$('#black, #box').fadeOut(500, function() {
						$('#box').html('');
					});
				}
			}
		}
	});
	
	$('#black').live('click',function(event) {
		event.preventDefault();
		$('#black, #box').stop(true, true);
		$('#black, #box').fadeOut(500, function() {
			$('#box').html('');
		});
	});

	
	$(document).bind('keyup', function(event) { 
		if(event.which == 27) {
			event.preventDefault();
			$('#black, #box').stop(true, true);
			$('#black, #box').fadeOut(500, function() {
				$('#black, #box').hide();
				$('#box').html('');
			});
		} else if(event.which == 107) {
			event.preventDefault();
			$('#cockpit-add').click();
		} else if(event.which == 70) {
			event.preventDefault();
			$('#cockpit-filter').click();
		}
	});

	/* Cockpit: Add */
	$('[data-action="cockpit-add"] .option').live('click', function(event) {
		event.preventDefault();
		alert('CALLBACK: Add \''+$(this).data('value')+'\'');
	});

	/* Cockpit: Filter */
	$('[data-action="cockpit-filter"] .option').live('click', function(event) {
		event.preventDefault();
		alert('CALLBACK: Filter: \''+$(this).data('value')+'\'');
	});

});