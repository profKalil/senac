<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Persistência de Dados - Servidor</title>
</head>
<body>
    <h1>TÍTULO</h1>
    <p>Este site está rodando no servidor embutido do PHP!</p>

    <?php
    $resultado = ''; // Inicializa a variável resultado

    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        

        // OPERADOR TERNÁRIO
        // $num1 = isset($_POST['num1']) ? (float)$_POST['num1'] : 0;   

        if (isset($_POST['num1'])) {
            $num1 = (float)$_POST['num1'];
        } else {
            $num1 = 0;
        }

        $num2 = isset($_POST['num2']) ? (float)$_POST['num2'] : 0;

        // Realiza o cálculo
        $resultado = $num1 + $num2;
    }
    ?>

    <form action="" method="post">
        <label for="num1">Número 1:</label>
        <input type="number" name="num1" id="num1" required>
        <label for="num2">Número 2:</label>
        <input type="number" name="num2" id="num2" required>
        <button type="submit">Calcular</button>
    </form>
    
    <p>RESULTADO: <?php echo $resultado; ?></p>

</body>
</html>