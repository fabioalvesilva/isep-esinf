# isep-esinf

Repositório de Estruturas de Informação, que contém exercícios realizados durantes as aulas práticas laboratoriais de ESINF e os 3 projetos realizados ao longo do semestre. 

## 1º Projecto - Países/COVID-19

Pretendia-se com este projeto o desenvolvimento de uma aplicação que permita gerir a informação de vários países relacionada com a pandemia COVID-19 tal como população, idade média, nº de casos, nº de óbitos, índices de fatores de risco como idade, diabetes, etc.
A informação encontra-se no ficheiro de texto: owid-covid-data.csv

Usando a Java Collection Framework foi desenvolvida as classes necessárias para implementar da forma mais eficiente possível as seguintes funcionalidades:

1. Carregar e guardar a informação relativa aos países e respetivos dados da pandemia COVID-19 a partir do ficheiro de texto fornecido.
2. Apresentar uma lista de países ordenados por ordem crescente do número mínimo de dias que foi necessário para atingir os 50.000 casos positivos. 
3. Devolver o total de novos_casos/novas_mortes por continente/mês, ordenado por continente/mês.
4. Devolver para cada dia de um determinado mês e para um dado continente, os países ordenados por ordem decrescente do número de novos casos positivos.
5. Devolver numa estrutura adequada, todos os países com mais de 70% de fumadores, ordenados por ordem decrescente do número de novas mortes.

## 2º Projecto - Rede Social

O presente projeto envolve a criação de uma biblioteca de classes respetivos métodos e testes relativos a uma rede social simplificada que gere uma rede de amigos bem como a rede de cidades onde habitam e as distâncias entre as mesmas. A informação encontra-se nos ficheiros de texto.

Nesta rede social dois utilizadores são amigos se tiverem uma ligação direta entre eles. As relações de amizade entre os vários utilizadores devem ser implementadas através de um grafo usando a representação matriz de adjacências. O grafo das cidades inclui apenas as capitais de países e respetivas distâncias geográficas e deve ser implementado usando a representação map de adjacências. Pretende-se a implementação das seguintes funcionalidades:

1. Construir os grafos a partir da informação fornecida nos ficheiros de texto. A capital de um país tem ligação direta com as capitais dos países com os quais faz fronteira. O cálculo da distância em Kms entre duas capitais deverá ser feito através das suas coordenadas.
2. Devolver os amigos comuns entre os n utilizadores mais populares da rede. A popularidade de um utilizador é dada pelo seu número de amizades.
3. Verificar se a rede de amizades é conectada e em caso positivo devolver o número mínimo de ligações necessário para nesta rede qualquer utilizador conseguir contactar um qualquer outro utilizador.
4. Devolver para um utilizador os amigos que se encontrem nas proximidades, isto é, amigos que habitem em cidades que distam um dado número de fronteiras da cidade desse utilizador. Devolver para cada cidade os respetivos amigos.
5. Devolver as n cidades com maior centralidade ou seja, as cidades que em média estão mais próximas de todas as outras cidades e onde habitem pelo menos p% dos utilizadores da rede de amizades, onde p% é a percentagem relativa de utilizadores em cada cidade.
6. Devolver o caminho terrestre mais curto entre dois utilizadores, passando obrigatoriamente pelas n cidade(s) intermédias onde cada utilizador tenha o maior número de amigos. As cidades origem, destino e intermédias devem ser todas distintas. O caminho encontrado deve indicar as cidades incluídas e a respetiva distância em km.

No relatório deste projecto foi ainda realizado a análise de complexidade das funcionalidades implementadas e melhoramentos possíveis.

## 3º Projecto - Tabela Periódica

No 3º projeto envolve a criação de uma biblioteca de classes, respetivos métodos e testes que permitam gerir a informação relativa a uma tabela periódica. Toda a informação da tabela encontra-se num ficheiro.

Usando apenas a estrutura árvore binária de pesquisa (BST), foi desenvolvido da forma mais eficiente possível as seguintes funcionalidades:

1. A/(s) classe/(s) que permita obter toda a informação relativa a cada um dos elementos da tabela periódica:
	1.1 - Pesquisa de elementos por qualquer um dos seguintes campos: Atomic Number, Element, Symbol ou Atomic Mass.
	1.2 - Pesquisa por intervalo de valores de Atomic Mass Através de dois valores (mínimo e máximo) passados por parâmetro, devolver o conjunto de elementos com Atomic Mass nesse intervalo ordenado por Discoverer e Year of Discovery (cresc./decres.) juntamente com um sumário do número de elementos devolvidos agrupados por Type e Phase.
2. Recorrendo apenas à estrutura árvore binária de pesquisa (BST), devolver por ordem decrescente as configurações electrónicas com mais do que uma repetição, agrupadas por número de repetições.
3. Constrir uma nova BST inserindo por ordem decrescente as configurações electrónicas com repetição acima de 2 obtidas na alínea anterior.
4. Um método que devolva os valores das duas configurações electrónicas mais distantes na árvore e a respectiva distância. Foi considerado como medida de distância entre as configurações electrónicas, o número de ramos que distam uma da outra.
5. Um método que transforme a árvore obtida alínea anterior numa árvore binária completa, inserindo nesta possíveis configurações electrónicas únicas.

No relatório deste projecto foi ainda realizado a análise de complexidade das funcionalidades implementadas e melhoramentos possíveis.