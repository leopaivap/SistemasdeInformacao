#Transação para inserção de turmas

BEGIN;
	INSERT INTO turma VALUES(NULL, "1SI", "1º Sistemas de Informação");
	INSERT INTO turma VALUES(NULL, "2SI", "2º Sistemas de Informação");
	INSERT INTO turma VALUES(NULL, "3SI", "3º Sistemas de Informação");
	INSERT INTO turma VALUES(NULL, "4SI", "4º Sistemas de Informação");
	INSERT INTO turma VALUES(NULL, "5SI", "5º Sistemas de Informação");
	INSERT INTO turma VALUES(NULL, "6SI", "6º Sistemas de Informação");
	INSERT INTO turma VALUES(NULL, "7SI", "7º Sistemas de Informação");
	INSERT INTO turma VALUES(NULL, "8SI", "8º Sistemas de Informação");
COMMIT;