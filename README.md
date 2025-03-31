# Projeto de Geração de Indice Remissivo

## Descrição do projeto

Este projeto tem a função de processar um arquivo de texto, identificar suas palavras-chave e gerar um arquivo de saída formatado com o Indice Remissivo junto com as oocorrências das palavras-chave encontradas.

## Estrutura do projeto

O projeto foi estruturado da seguinte maneira:
```
Gerador-Indice-remissivo/
├── src/
│   ├── Main.java
│   ├── buffers/
│   │   ├── BufferedReader_KeyWords.java
│   │   ├── BufferedReader_Texto.java
│   │   ├── BufferedWriter_Saida.java
│   ├── palavra/
│   │   ├── Palavras.java
├── texto.txt
├── palavras.txt
├── saida.txt
├── README.md
```

## Como Compilar

Antes de executar, clone esse projeto e verifique se está acessando a pasta src, para isso basta:
```
cd src
```
Agora digite a seguinte linha de comando para compilar o projeto:
```
javac Main.java
```

## Como Executar

Após a compilação, basta executar a linha de comando:
```
java Main texto.txt palavras.txt saida.txt
```

Você deve saber que:
`texto.txt` é o arquivo de entrada contendo o texto que vai ser processado pelo código.
`palavras.txt` é o arquivo que contém a lista de palavras-chave para ser utilizado pelo código.
`saida.txt` será o arquivo gerado com as palavras-chave encontradas junto com suas ocorrências.

## Exemplo de entrada

Arquivo `texto.txt`:
```
“Good programming is not learned
from generalities, but by seeing how
significant programs can be made
clean, easy to read, easy to maintain
and modify,
human-engineered, efficient, and
reliable, by the application of
common sense and
by the use of good programming practices.”
```
Arquivo `palavras.txt`:
```
programming, programs, easy, by, human-engineered, and, be, to
```

## Exemplo de Saída

Arquivo `saida.txt`:
```
and[5, 6, 8]
be[3]
by[2, 7, 9]
easy[4, 4]
human-engineered[6]
programming[1, 9]
programs[3]
to[4, 4]
```



