$(function() {
    $('.btn-edit').click(function() {
        var id = $(this).data('id');
        var link = 'http://localhost:8081/admin-account';

        
        $.ajax({
            url: link,
            type: 'GET',
            dataType: 'JSON',
            data: {
                account_id: id,
                action: 'edit'
            },
            success: function(res) {
                $('#email').val(res.email);
                console.log(res.email)
                $('#fullname').val(res.fullName);
                console.log(res.fullname)
                $('#phone').val(res.phone);
                $('#address').val(res.addRess);
                $('#account_id').val(res.id);
                console.log(res.address)
                console.log("success" + res)
            },
            error: function(err) {
                console.log("error: " + err)
            }

        })
    });
    
    $('.btnDelete').click(function() {
        var id = $(this).data('id');
        var link = 'http://localhost:8081/admin-account';
        
        $.ajax({
            url: link,
            type: 'GET',
            dataType: 'JSON',
            data: {
                account_id: id,
                action: 'delete'
            },
            success: function(res) {
              if(res === 'success') {
            	  $('#account_' + id).remove();
              }
            	  window.location.href = "/admin-account?alerts=success";
            },
            error: function(err) {
            	window.location.href = "/admin-account?alerts=error";
            	
            }

        })
    })
    $('.btn-default_model').click(function(){
    	$('form .form-control').val('');
    })
})