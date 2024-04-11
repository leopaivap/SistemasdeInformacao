const form = document.getElementById('form');
const descInput = document.getElementById('descricao');
const valorInput = document.querySelector('#montante');
const balancoH1 = document.getElementById('balanco');



form.addEventListener("submit", event => {
    event.preventDefault(); // Não submete formulário

    const descTransacao = descInput.value.trim();
    const valorTransacao = valorInput.value.trim();

    if (descInput == '') {
        alert('Informe a descrição da transação');
        descInput.focus();
        return;
    }

    if (valorInput == '') {
        alert('Informe o valor da transação');
        valorInput.focus();
        return;
    }


    const transacao = {
        id: parseInt(Math.random() * 10000),
        desc: descTransacao,
        value: valorTransacao
    }

    somaAoSaldo(transacao);

    descInput.value = '';
    valorInput.value = '';
    descInput.focus();
});

function somaAoSaldo(transacao) {
    // recuperar o elemento
    // pegar o valor e remover o R$

    let valorBalanco = balancoH1.innerHTML.trim();
    valorBalanco = valorBalanco.replace("R$", "");
    valorBalanco = parseFloat(valorBalanco);

    alert(typeof valorBalanco + ": "+valorBalanco);
}