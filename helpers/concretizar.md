### Funcionalidade a concretizar

A funcionalidade necessária para a entrega intermédia, além da abertura de todos os submenus, é a seguinte:

* Leitura, interpretação e representação em memória do ficheiro textual indicado pela propriedade **[import](https://web.tecnico.ulisboa.pt/~david.matos/w/pt/index.php/Programa%C3%A7%C3%A3o_com_Objectos/Projecto_de_Programa%C3%A7%C3%A3o_com_Objectos/Enunciado_do_Projecto_de_2021-2022#Leitura_de_Dados_a_Partir_de_Ficheiros_Textuais "Programação com Objectos/Projecto de Programação com Objectos/Enunciado do Projecto de 2021-2022")** (implica implementar algumas classes do "core")
* Menu principal: [Salvaguarda do estado actual da aplicação](https://web.tecnico.ulisboa.pt/~david.matos/w/pt/index.php/Programa%C3%A7%C3%A3o_com_Objectos/Projecto_de_Programa%C3%A7%C3%A3o_com_Objectos/Enunciado_do_Projecto_de_2021-2022#Salvaguarda_do_estado_actual_da_aplica.C3.A7.C3.A3o "Programação com Objectos/Projecto de Programação com Objectos/Enunciado do Projecto de 2021-2022"): "Abrir" e "Guardar" -- implementação completa
* Menu principal: [Gestão e consulta de dados da aplicação](https://web.tecnico.ulisboa.pt/~david.matos/w/pt/index.php/Programa%C3%A7%C3%A3o_com_Objectos/Projecto_de_Programa%C3%A7%C3%A3o_com_Objectos/Enunciado_do_Projecto_de_2021-2022#Gest.C3.A3o_e_consulta_de_dados_da_aplica.C3.A7.C3.A3o "Programação com Objectos/Projecto de Programação com Objectos/Enunciado do Projecto de 2021-2022"): abertura dos vários submenus (comandos fornecidos já implementados).
* ~~Menu principal: [Mostrar data actual](https://web.tecnico.ulisboa.pt/~david.matos/w/pt/index.php/Programa%C3%A7%C3%A3o_com_Objectos/Projecto_de_Programa%C3%A7%C3%A3o_com_Objectos/Enunciado_do_Projecto_de_2021-2022#Mostrar_data_actual "Programação com Objectos/Projecto de Programação com Objectos/Enunciado do Projecto de 2021-2022") e [Avançar data actual](https://web.tecnico.ulisboa.pt/~david.matos/w/pt/index.php/Programa%C3%A7%C3%A3o_com_Objectos/Projecto_de_Programa%C3%A7%C3%A3o_com_Objectos/Enunciado_do_Projecto_de_2020-2021#Avan.C3.A7ar_data_actual "Programação com Objectos/Projecto de Programação com Objectos/Enunciado do Projecto de 2020-2021").-~~ -> DONE
* [Menu de Gestão de Produtos](https://web.tecnico.ulisboa.pt/~david.matos/w/pt/index.php/Programa%C3%A7%C3%A3o_com_Objectos/Projecto_de_Programa%C3%A7%C3%A3o_com_Objectos/Enunciado_do_Projecto_de_2021-2022#Menu_de_Gest.C3.A3o_de_Produtos "Programação com Objectos/Projecto de Programação com Objectos/Enunciado do Projecto de 2021-2022") -- implementar as operações "Visualizar todos os produtos? e "Visualizar todos os lotes"". .
* [Menu de Gestão de Parceiros](https://web.tecnico.ulisboa.pt/~david.matos/w/pt/index.php/Programa%C3%A7%C3%A3o_com_Objectos/Projecto_de_Programa%C3%A7%C3%A3o_com_Objectos/Enunciado_do_Projecto_de_2021-2022#Menu_de_Gest.C3.A3o_de_Parceiros "Programação com Objectos/Projecto de Programação com Objectos/Enunciado do Projecto de 2021-2022") -- implementar as operações "Mostrar parceiro", "Mostrar todos os parceiros" e "Registar parceiro".

Todos os outros comandos em todos os menus têm de estar concretizados ("execute" pode estar vazio). Não é má prática implementar os outros comandos, pois poupa esforço para a entrega final, mas não serão avaliados nesta entrega.

Note-se que os comandos que abrem os vários menus da aplicação já estão concretizados e portanto não podem ser alterados. Note-se ainda que a classe **App** e os vários menus também não podem ser alterados.

A concretização das entidades do domínio da aplicação (pertencentes a **ggc.core**) tem de ser suficiente para suportar os comandos necessários para concretizar a funcionaldiade indicada acima.