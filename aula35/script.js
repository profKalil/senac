function pergunta() {
    const perguntaInput = document.getElementById('perguntaInput');
    const btnSim = document.getElementById('btnSim');
    const btnNao = document.getElementById('btnNao');
    const resultDiv = document.getElementById('result');

    let perguntasCertas = 0;
    let perguntaAtual = 0;
    let perguntas = [
        'Pergunta 1:  ',
        'Pergunta 2:  ',
        'Pergunta 3:  '
    ];

    // Função para mostrar a próxima pergunta
    function mostrarPergunta() {
        if (perguntaAtual < perguntas.length) {
            perguntaInput.value = perguntas[perguntaAtual];
        } else {
            if (perguntasCertas === perguntas.length) {
                alert('FIM');
            } else {
                alert ('REINICIAR');
            }
        }
    }

    // Função para processar a resposta
    function processarResposta(respostaCorreta) {
        if (respostaCorreta) {
            perguntasCertas++;
        }
        perguntaAtual++;
        mostrarPergunta();
    }

    // Eventos de clique para os botões
    btnSim.addEventListener('click', () => processarResposta(true));
    btnNao.addEventListener('click', () => processarResposta(false));

    // Inicia o quiz
    mostrarPergunta();
}

document.addEventListener('DOMContentLoaded', pergunta);