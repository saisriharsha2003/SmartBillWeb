var check = function() {
  const pwd = document.getElementById('password');
  const cpwd = document.getElementById('cpassword');
  const msg = document.getElementById('message');
  cpwd.addEventListener('input', function()
  {
    if(pwd.value == cpwd.value)
    {
      msg.textContent = "Password matches.";
      msg.classList.add('match');
      msg.classList.remove('nomatch');
    }else {
      msg.textContent = "Passwords do not match.";
      msg.classList.add('nomatch');
      msg.classList.remove('match');
    }
  });
}

let subm = document.getElementById("subMenu");
function toggleMenu() {
	subm.classList.toggle("open-menu");
}
	
var login_check = function() {
	  const pwd = document.getElementById('lpwd');
	  const cpwd = document.getElementById('lcpwd');
	  const msg = document.getElementById('login_message');
	  cpwd.addEventListener('input', function()
	  {
	    if(pwd.value == cpwd.value)
	    {
	      msg.textContent = "Password matches.";
	      msg.classList.add('match');
	      msg.classList.remove('nomatch');
	    }else {
	      msg.textContent = "Passwords do not match.";
	      msg.classList.add('nomatch');
	      msg.classList.remove('match');
	    }
	  });
}

if(document.getElementById('download-receipt'))
{
	document.getElementById('download-receipt').addEventListener('click', function() {
		window.jsPDF = window.jspdf.jsPDF;
		const element = document.getElementById('receipt'); 
	
		html2canvas(element, {
		    scale: 0.8,
		    logging: true,
		    allowTaint: false,
		    backgroundColor: null
		}).then(function(canvas) {
		    var base64image = canvas.toDataURL("image/png");
	
		    var imgWidth = 210; 
		    var pageHeight = 295;  
		    var imgHeight = canvas.height * imgWidth / canvas.width;
		    var heightLeft = imgHeight;    
		    const pdf = new jsPDF(); 
		    var position = 0;
	
	
		    var width = pdf.internal.pageSize.getWidth();
		    var height = pdf.internal.pageSize.getHeight();    
		    pdf.addImage(base64image,'PNG', 10, 10, imgWidth-17, imgHeight);
		    heightLeft -= pageHeight;
	
		    while (heightLeft >= 0) {
		        position = heightLeft - imgHeight;
		        pdf.addPage();
		        pdf.addImage(base64image,'PNG', 10, position, imgWidth-17, imgHeight);
		        heightLeft -= pageHeight;
		    }
	
		    pdf.save('Receipt.pdf');
		});
	});
}
