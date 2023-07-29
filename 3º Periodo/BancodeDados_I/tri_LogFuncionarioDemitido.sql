BEGIN
    IF (NEW.dataDemissao != '0000-00-00') THEN
      
        
        SET @mensagem = CONCAT("Funcionario Demitido: ", NEW.nome);
        INSERT INTO auditoria VALUES (NULL, @mensagem, "funcionario", NOW(), USER());
    END IF;
END