function tabuada() {

    let numero = document.getElementById('txt-numero');
    let selectTab = document.getElementById('select-tab');

    if (numero.value.length == 0) {
        window.alert('Por favor, digite um número!');
    } else {
        num = Number(numero.value);
        selectTab.innerHTML = '';
        for (c = 0; c <= 10; c++) {
            let item = document.createElement('option');
            item.text = `${num} x ${c} = ${num * c}`;
            item.value = `tab${c}`
            selectTab.appendChild(item);
        }
    }
}