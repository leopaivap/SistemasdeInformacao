function contar() {
    let inicio = document.getElementById('txt-inicio');
    let fim = document.getElementById('txt-fim');
    let passos = document.getElementById('txt-passos');
    let resultado = document.getElementById('res');

    if (inicio.value.length == 0 || fim.value.length == 0 || passos.value.length == 0) {
        resultado.innerHTML = "<h3>Impossível contar!</h3>"
        //window.alert("[ERRO] Faltam dados!");
    }
    else {
        resultado.innerHTML = "<h3>Contando: <br></h3>"
        i = Number(inicio.value);
        f = Number(fim.value);
        p = Number(passos.value);
        let pulaLinha = 0;

        if (p <= 0) {
            window.alert("Passo inválido! Considerando Passo 1");
            p = 1;
        }
        if (i < f) {
            for (c = i; c <= f; c += p) {
                if (pulaLinha == 6) {
                    resultado.innerHTML += `${c} \u{2620}<br>`
                    pulaLinha = 0;
                }
                else {
                    resultado.innerHTML += `${c} \u{2620} `
                    pulaLinha++;
                }
            }
        } else {
            for (c = i; c >= f; c -= p) {
                if (pulaLinha == 6) {
                    resultado.innerHTML += `${c} \u{2620}<br>`
                    pulaLinha = 0;
                }
                else {
                    resultado.innerHTML += `${c} \u{2620} `
                }
            }
        }
        resultado.innerHTML += `\u{1F4A4}`
    }
}