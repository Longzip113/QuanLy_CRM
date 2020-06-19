$(function() {
    $('.btn-group-edit').click(function() {
        var id = $(this).data('id');
        var link = 'http://localhost:8081/admin-group';

        
        $.ajax({
            url: link,
            type: 'GET',
            dataType: 'JSON',
            data: {
            	group_id: id,
                action: 'edit'
            },
            success: function(res) {
                $('#description').val(res.description);
                $('#group_name').val(res.name);
                $('#group_id').val(res.id);
                console.log("success" + res)
            },
            error: function(err) {
                console.log("error: " + err)
            }

        })
    });
    
    $('.btn_group_Delete').click(function() {
        var id = $(this).data('id');
        var link = 'http://localhost:8081/admin-group';
        
        $.ajax({
            url: link,
            type: 'GET',
            dataType: 'JSON',
            data: {
                group_id: id,
                action: 'delete'
            },
            success: function(res) {
              if(res === 'success') {
            	  $('#group_' + id).remove();
              }
            	  window.location.href = "/admin-group?alerts=success";
            },
            error: function(err) {
            	window.location.href = "/admin-group?alerts=error";
            	
            }

        })
    })
    $('.btn-default_model').click(function(){
    	$('form .form-control').val('');
    	$('form textarea').val('');
    })
})