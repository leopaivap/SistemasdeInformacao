function carregar() {
    msg = window.document.getElementById('msg');
    img = window.document.getElementById('imagem');

    var data = new Date();
    var hora = data.getHours();

    if (hora >= 0 && hora < 12) {
        // BOM DIA
        msg.innerHTML = `Agora são ${hora} da manhã<br>Bom Dia!`;
        img.src = './images/solNascendo.jpg';

    } else if (hora >= 12 && hora < 19) {
        // BOA TARDE
        msg.innerHTML = `Agora são ${hora} da tarde<br>Boa Tarde!`;
        img.src = './images/entardecer.jpg';

    } else {
        // BOA NOITE
        msg.innerHTML = `Agora são ${hora} da noite<br>Boa Noite!`;
        img.src = './images/noite.jpg';

    }
}
