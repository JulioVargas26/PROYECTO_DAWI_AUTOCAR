
//carrusel
var imgs = ["banneraros.png","bannerllantas.png","Bannerlunas.jpg"];
var c=0;
var t;

var ban = document.getElementById("banerimg");

function rotation(){
    ban.setAttribute("src","img/baner/"+imgs[c]);
    c++;
    if(c>=3)c=0;
    t=setTimeout("rotation()",3000);
}
rotation();



