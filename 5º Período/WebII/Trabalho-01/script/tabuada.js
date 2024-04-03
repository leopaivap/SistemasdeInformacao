function tabuada() {

    numero = document.getElementById('txt-numero');
    select = document.getElementById('select-tabuada')

    titulo = document.getElementById('resultado-titulo');


    if (numero.value.length == 0) {
        window.alert('[ERRO] Insira um número para prosseguir!');
    } else {
        titulo.innerHTML = `Tabuada do ${numero.value}:`
        select.innerHTML = '';
        num = Number(numero.value);
        for (c = 0; c <= 10; c++) {
            item = document.createElement('option');
            item.text = `${num} x ${c} = ${num * c}`;
            item.value = `tab${c}`
            select.appendChild(item);
        }
    }
}