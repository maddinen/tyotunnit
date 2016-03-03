<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<title>Tunnit</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>

//dokumentin latautuessa aktivoidaan tapahtumankuuntelijat
$(document).ready(function(){
	
	//tyhjennysnappia painettaessa
	$("#tyhjennysnappi").click(function() {
		$("#lista").empty();
	});
	
	//latausnappia painettaessa
	$("#latausnappi").click(function() {
		
		//ladataan JSON-dataa palvelimelta
		$.getJSON( "tunnit.json", function( data ) {
			$.each( data, function( key, val ) {
				//listaan uusi tietue
				var h = $("<section class='Olio'/>").appendTo("#lista");
				//tiedot
				$("<p/>").text(val.kayttaja_id).appendTo(h);
				$("<p/>").text(val.paivamaara).appendTo(h);
				$("<p/>").text(val.tuntien_maara).appendTo(h);
				$("<p/>").text(val.selite).appendTo(h);
			});
		}).error(function() { //palvelinyhteys aiheutti virheen
			$("<p class='Error'>Virhe: Palvelin ei palauta JSON-dataa. Tarkista tietokantayhteys.</p>").appendTo("#lista");
		});
		
	});
	
});
</script>
</head>
<body>
<h1>Tunnit</h1>
<p><button id="latausnappi">Lataa</button> <button id="tyhjennysnappi">Tyhjenn&auml;</button>
<div id="lista" ></div>
</body>
</html>