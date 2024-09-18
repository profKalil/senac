const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');

const app = express();
app.use(cors());

// Configurar a conexão com o banco de dados
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'senha', // coloque sua senha
  database: 'quiz_db' // nome do seu banco de dados
});

// Rota para obter as perguntas
app.get('/perguntas', (req, res) => {
  const sql = 'SELECT * FROM perguntas'; // Assume que você tem uma tabela chamada 'perguntas'
  db.query(sql, (err, result) => {
    if (err) {
      return res.status(500).send(err);
    }
    res.json(result);
  });
});

// Iniciar o servidor
app.listen(5000, () => {
  console.log('Servidor rodando na porta 5000');
});
