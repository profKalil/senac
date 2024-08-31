document.addEventListener('DOMContentLoaded', function() {
    const tarefaInput = document.getElementById('tarefa');
    const adicionarBtn = document.getElementById('adicionarBtn');
    const salvarBtn = document.getElementById('salvarBtn');
    const carregarBtn = document.getElementById('carregarBtn');
    const fileInput = document.getElementById('fileInput');
    const corpoTabela = document.getElementById('corpoTabela');

    // Função para adicionar uma tarefa à tabela
    function adicionarTarefa() {
        const tarefa = tarefaInput.value.trim();

        if (tarefa) {
            const tr = document.createElement('tr');
            const td = document.createElement('td');
            td.textContent = tarefa;
            tr.appendChild(td);
            corpoTabela.appendChild(tr);
            tarefaInput.value = '';
        } else {
            alert('Por favor, digite uma tarefa.');
        }
    }

    // Função para gerar o nome do arquivo com base na data e hora atual
    function gerarNomeArquivo() {
        const now = new Date();
        const ano = now.getFullYear();
        const mes = String(now.getMonth() + 1).padStart(2, '0'); // Meses começam do 0
        const dia = String(now.getDate()).padStart(2, '0');
        const hora = String(now.getHours()).padStart(2, '0');
        const minuto = String(now.getMinutes()).padStart(2, '0');
        const segundo = String(now.getSeconds()).padStart(2, '0');
        return `lista_tarefa_${ano}${mes}${dia}_${hora}${minuto}${segundo}.txt`;
    }

    // Função para salvar as tarefas em um arquivo .txt
    function baixarTarefas() {
        const tarefas = Array.from(corpoTabela.children).map(tr => tr.textContent);
        const tarefasTexto = tarefas.join('\n');
        
        const blob = new Blob([tarefasTexto], { type: 'text/plain' });
        const url = URL.createObjectURL(blob);
        
        const a = document.createElement('a');
        a.href = url;
        a.download = gerarNomeArquivo(); // Usa a função para gerar o nome do arquivo
        a.click();
        
        URL.revokeObjectURL(url);
    }

    // Função para carregar tarefas de um arquivo .txt
    function carregarTarefas() {
        fileInput.click(); // Abre o seletor de arquivos
    }

    // Função para processar o arquivo selecionado
    function processarArquivo(event) {
        const arquivo = event.target.files[0];
        if (arquivo) {
            const reader = new FileReader();
            
            reader.onload = function(e) {
                const texto = e.target.result;
                const tarefas = texto.split('\n');
                
                corpoTabela.innerHTML = ''; // Limpa a tabela antes de adicionar novas tarefas
                
                tarefas.forEach(tarefa => {
                    if (tarefa.trim()) {
                        const tr = document.createElement('tr');
                        const td = document.createElement('td');
                        td.textContent = tarefa.trim();
                        tr.appendChild(td);
                        corpoTabela.appendChild(tr);
                    }
                });
            };
            
            reader.readAsText(arquivo);
        }
    }

    // Adiciona ouvintes de eventos aos botões
    adicionarBtn.addEventListener('click', adicionarTarefa);
    salvarBtn.addEventListener('click', baixarTarefas);
    carregarBtn.addEventListener('click', carregarTarefas);
    fileInput.addEventListener('change', processarArquivo);
});
