$(document).ready(function() {
	
   $(".soNumero").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
             // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) || 
             // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
    
   	$(".numeric").setMask("9999999999#");
    $(".porcentagem").setMask("percent");
    $(".idEmpresa").setMask("******");
    $(".cpf").setMask("cpf");
    $(".dinheiro").setMask("decimal");
    
    $(".telefone").setMask('phone');
	$(".telefone").focus(function()
	{
		$(this).setMask('phone');
	});
	$(".telefone").blur(function()
	{
		// Se o telefone tiver 9 dígitos, aplica a máscara (99) 99999-9999;
		$(this).setMask('phone');
		
		// Se não, aplica a máscara (99) 9999-9999;
		if(this.value.length == 14 || this.value.length == 10) {
			$(this).setMask('eightDigitsPhone');
		}
	});
});