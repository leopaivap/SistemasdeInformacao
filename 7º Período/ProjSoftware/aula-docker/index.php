<!DOCTYPE html>
<html>
    <head>
        <title>Conteiner PHP</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        
        <div class="calculator">
            <h2>Calculadora de Nota Ponderada</h2>
            <p>Cálculo da nota final = (nota do semestre  + nota prova final * 2) / 3</p>
            
            <form method="post" action="">
                <div>
                    <label for="semesterGrade">Nota do Semestre:</label>
                    <input type="number" id="semesterGrade" name="semesterGrade" step="0.1" min="0" max="10" required>
                </div>
                
                <div>
                    <label for="finalExamGrade">Nota da Prova Final:</label>
                    <input type="number" id="finalExamGrade" name="finalExamGrade" step="0.1" min="0" max="10" required>
                </div>
                
                <button type="submit">Calcular</button>
            </form>
            
            <?php
            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                // Obter notas do formulário
                $semesterGrade = filter_input(INPUT_POST, 'semesterGrade', FILTER_VALIDATE_FLOAT);
                $finalExamGrade = filter_input(INPUT_POST, 'finalExamGrade', FILTER_VALIDATE_FLOAT);
                
                // Validar entrada
                if ($semesterGrade === false || $finalExamGrade === false ||
                    $semesterGrade < 0 || $semesterGrade > 10 ||
                    $finalExamGrade < 0 || $finalExamGrade > 10) {
                    echo "<p>Por favor, insira notas válidas entre 0 e 10.</p>";
                } else {
                    // Calcular nota final: (nota do semestre * 2 + nota prova final) / 3
                    $finalGrade = ($semesterGrade  + $finalExamGrade * 2) / 3;
                    $finalGrade = round($finalGrade, 1); // Arredondar para uma casa decimal
                    
                    // Determinar se o aluno passou (considerando nota mínima de 6.0)
                    $status = ($finalGrade >= 6) ? "Aprovado" : "Reprovado";
                    $statusClass = ($finalGrade >= 6) ? "approve" : "fail";
                    
                    // Exibir resultado
                    echo "<div class='result'>";
                    echo "<h3>Resultado:</h3>";
                    echo "<p><strong>Nota do Semestre:</strong> " . number_format($semesterGrade, 1) . "</p>";
                    echo "<p><strong>Nota da Prova Final:</strong> " . number_format($finalExamGrade, 1) . "</p>";
                    echo "<p><strong>Nota Final:</strong> " . number_format($finalGrade, 1) . "</p>";
                    echo "<p><strong>Situação:</strong> <span class='$statusClass'>$status</span></p>";
                    echo "</div>";
                }
            }
            ?>
        </div>
    </body>
</html>