package com.supercartoes.br.ui.utils

class Const {

    companion object {
        const val HOME_FRAGMENT = "HOME_FRAGMENT"
        const val PAY_FRAGMENT = "PAY_FRAGMENT"
        const val TRANSFER_FRAGMENT = "TRANSFER_FRAGMENT"
        const val CARD_FRAGMENT = "CARD_FRAGMENT"
        const val MENU_FRAGMENT = "MENU_FRAGMENT"
        const val TOUR_FRAGMENT = "TOUR_FRAGMENT"
        const val WELCOME_TOUR_FRAGMENT = "WELCOME_TOUR_FRAGMENT"
        const val TAB_CENARY_FORM = 1
        const val TAB_CENARY_BANK = 0
        const val ITEM_POSITION = "item_position"
        const val PHYSIC_CARD: String = "physic_card"

        const val HISTORIC_LIMIT = 20
        const val HISTORIC_EXCHANGE_CURRENCY = "BRL"

        const val LOGIN_STEP_ONE: String = "login_1"
        const val LOGIN_STEP_ONE_B: String = "login_1_b"
        const val LOGIN_STEP_TWO: String = "login_2"
        const val FREEMIUM_COMPLETE_CAD: String = "freemium_complete_cad"
        const val FORGOT_PAASSWORD: String = "forgot_password"
        const val RESET_PAASSWORD: String = "reset_password"
        const val OPEN_ACCOUNT_ONE: String = "open_account_one"
        const val OPEN_ACCOUNT_TWO: String = "open_account_two"
        const val OPEN_ACCOUNT_THREE: String = "open_account_three"
        const val OPEN_ACCOUNT_FOUR: String = "open_account_four"
        const val OPEN_TERMS: String = "open_terms"
        const val CONTINUE_CAD: String = "continue_cad"
        const val FREEMIUM_SUCCES: String = "freemium_success"
        const val WARNING_CAD: String = "warning_cad"

        const val SETUP_ADDRESS: String = "setupAddress"
        const val DELETE_ADDRESS: String = "deleteAddress"
        const val EDIT_ADDRESS: String = "editAddress"
        const val ADD_ADDRESS: String = "addAddress"

        const val SIGNATURE_SETUP: String = "setupSignature"

        const val TOKEN_SMS: String = "token_sms"
        const val TOKEN_EMAIL: String = "token_email"


        const val FIREBASE_SCREEN_TRANSITION: String = "screen_transition"
        const val FIREBASE_CUSTOM_EVENT: String = "custom_event"
        const val FIREBASE_SCREEN_NAME: String = "screenName"


        const val FIREBASE_EVENT_ACTION : String = "eventAction"
        const val FIREBASE_EVENT_CATEGORY : String = "eventCategory"
        const val FIREBASE_EVENT_LABEL : String = "eventLabel"
        const val FIREBASE_EVENT_VALUE : String = "eventValue"
        const val FIREBASE_EVENT_NONINTERACTION : String = "eventNonInteraction"
        const val FIREBASE_EVENT_USERID : String = "userID"
        const val FIREBASE_VAR_NAME: String = "vaName"
        
        const val SANTANDER_APP_PACKAGE: String = "com.santander.app"

        const val CHOOSED_PLAN: String = "planoEscolhido"
        const val CURRENT_PLAN: String = "planoAtual"
        const val CARD_TYPE: String = "TipoCartao"
        const val CRYPTO_ID: String = "cryptoID"

        const val UBOTSJID: String = "internal-atendimento-brasil"
        const val PASSWORD_CHATBOT: String = "1a2b3c"
        const val HOSTNAME: String = "xmpp.ubots.com.br"
        const val DOMAIN: String =  "superdigital.ubots.com.br"
        const val RESSOURCE: String = "superdigital"
        const val PORT: Int = 9000

        //Firebase Push Notification -- variaveis de identificação do push
        const val FIREBASE_PUSH_NOTIFICATION = "FIREBASE_PUSH_NOTIFICATION"
        const val FIREBASE_PUSH_NOTIFICATION_IDENTIFY = "identify"
        const val FIREBASE_PUSH_NOTIFICATION_TYPE = "type"
        const val FIREBASE_PUSH_NOTIFICATION_TYPE_VALUE = "typevalue"
        const val FIREBASE_PUSH_NOTIFICATION_MESSAGE = "message"

        //Origem Midia
        const val KEY_UTM_SOURCE = "utm_source"
        const val KEY_UTM_MEDIUM = "utm_medium"
        const val KEY_UTM_CAMPAIGN = "utm_campaign"
        const val KEY_UTM_CONTENT = "utm_content"
        const val KEY_UTM_TERM = "utm_term"
        const val KEY_GCLID_ID = "gclid"
        const val KEY_GCLID_CAMPAIGN = "campaignid"
        const val KEY_GCLID_ADGROUP = "adgroupid"

        //Avaliação
        const val RATING : Int = 1
        const val FEEDBACK : Int = 2
        const val DISPENSED : Int = 3

    }

    enum class Rotulo (val tag: String){

        preenchimentoCampoValor ("Preenchimento | Campo: {0} | Valor: {1}"),
        toqueBtn          ("Toque | Botão: {0}"),
        toqueContato      ("Toque | Contato"),
        toqueLink         ("Toque | Link: {0}"),
        nomeCampo         ("Preenchimento | Campo: {0}"),
        toqueBtnPart      ("Toque | Botão: {botao} | Número de Participantes: {0}"),
        sucessoErro       ("{Sucesso/Erro} | Mensagem: {0}"),
        erroMsg           ("Erro | Mensagem: {0}"),
        nomeCampPart      ("Preenchimento  | Campo: {nome do campo} | Número de Participantes: {0}"),
        sucessoErroEdicao ("{Sucesso/Erro} | Edição de Vaquinha | Mensagem: {mensagem de erro} | Número de Participantes: {0}"),
        expacaoContracao  ("{Expansão/Contração} | Link: {0}"),
        expacaoContrBtn   ("{Expansão/Contração} | Botao: {0}"),
        preenCampTipo     ("Preenchimento | Campo: {0} | Tipo: {1}"),
        toqueControl      ("Toque | Controle: {0}"),
        campoForma        ("Preenchimento | Campo: {valor a ser enviado} | Forma: {0}"),
        toqueLinkEndTipo  ("Toque | Link: {link} | Tipo de endereço: {0}"), //residencial/comercial
        expContEnd        ("{Expansão/Contração} | Tipo de endereço: {0}"), //residencial/comercial
        buscaCep          ("{Sucesso/Erro} | Pesquisa de CEP | Mensagem: mensagem de erro | CEP: {0}"),
        buscatipoEnd      ("{Sucesso/Erro} | Mensagem: mensagem de erro | Tipo de endereço: {0}"), //residencial/comercial
        toqueForma        ("Toque | Forma de envio: {0}"),
        erroCampoMsgForm  ("Erro | Campo: {nome do campo} | Mensagem: {mensagem de erro} | Forma: {0}"),
        toqueBtnForm      ("Toque | Botão: Continuar | Forma: forma de envio"),
        toqueControlForm  ("Toque | Controle: Deslize para Continuar | Forma: {0}"),
        campoMoeda        ("Preenchimento | Campo: {nome do campo} | Moeda: {0}"),
        campoPais         ("Preenchimento | Campo: Escolha seu destino | Valor: {0}"),
        botaoMoeda        ("Toque | Botão: {botao} | Moeda: {moedaDe} para {0}"),
        controleMoeda     ("Toque | Controle: Deslize para Continuar | Moeda: {0} para {1}"),
        campoMoedaPara    ("Preenchimento | Campo: {nome do campo} | Moeda: {0} para {1}"),
        erroMoeda         ("Erro | Moeda: {moedaDe} para {moedaPara} | Mensagem: Mensagem de erro"),
        sucessoMoeda      ("Sucesso | Moeda: {moedaDe} para {moedaPara}"),
        checkOpcao        ("Toque | Checkbox: {nome do campo} | Opção: {0}"),
        toqueDireMes      ("Toque | Seta: {botao} | Mês Exibido: {0}"),
        campoTermo        ("Preenchimento | Campo: {nome do campo} | Termo Pesquisado: {0}"),
        sucessoErroTermo  ("{Sucesso/Erro}| Termo Pesquisado: {nome do campo} | Número de Resultados: {0}"),
        filtroOpcaoresult ("Filtro | Filtro: {link} | Opção: {nome do campo} | Número de Resultados: {0}"),
        campoPeriodo      ("Preenchimento | Campo: {nome do campo} | Período: {0}"),
        toqueCampo        ("Toque | Campo: {0}"),
        linkTipoItem      ("Toque | Link: {link} | Tipo de item: {0}"),
        linkAreaTipo      ("Toque | Link: {link} | Área: {nome do campo} | Tipo de item: {0}"),
        linkTipoCartao    ("Toque | Link: Cartão | Tipo de cartão: {0}"),
        alternOptTipo     ("Alternância | Opção: {botao} | Tipo de cartão: {0}"),
        msgErro           ("Exibição | Informação | Mensagem: {0}"),
        erroCadastro      ("Erro | Campo: {nome do campo} | Mensagem: mensagem de erro"),
        completarPerfil   ("Preenchimento | Campo: {nome do campo} | Plano Escolhido: {0}"),
        cartoesAssociar   ("Preenchimento | Campo: {nome do campo} | Valor: {0}"),
        completarPerfilBt ("Toque | Botão: {botao} | Plano Escolhido: {0}"),
        completPerfil     ("Sucesso | Plano Escolhido: {0}"),
        exclusaoVaquinha  ("Sucesso | Exclusão | Número de Participantes:{0}"),
        sucessoVaquinha   ("Sucesso | Número de Participantes: {0}"),
        erroExclusaoVaquinha  ("Erro | Exclusão | Mensagem: {mensagem de erro} | Número de Participantes: {0}"),
        erroNovaVaquinha  ("Erro | Mensagem: {mensagem de erro} | Número de Participantes: {0}"),
        expContAssinatura ("{Expansão/Contração} | Plano: {0}"),
        sucessoFormaEscolhida ("Sucesso | Forma Escolhida: {0}"),
        erroMensagemFormaEscolhida ("Erro | Mensagem: {mensagem de erro} | Forma Escolhida: {0}"),
        buscaContatos     ("Preenchimento | Busca de contatos"),
        toqueBtnFormaEnvio ("Toque | Botão: Continuar | Forma: {0}"),
        filtroLimpeza      ("Filtro | Limpeza de Filtro | Item apagado: {0}"),
        erroComprovante    ("Erro | Comprovante | Tipo de item: {tipo} | Mensagem: {0}"),
        sucessoComprovante ("Sucesso | Comprovante | Tipo de item: {0}"),
        toqueBotaoRachar   ("Toque | Botão: Rachar | Tipo de item: {0}"),
        toqueRecarga       ("Toque | Valor de Recarga | Valor: {moedaDe} | Operadora: {0}"),
        intervaloDatas     ("Toque | Intervalo de Datas | Seta: {0}"),
        swipeFrontDoor     ("Swipe | Telas explicativas"),
        toqueBtnBack ("Toque | Botão: Voltar"),
        toqueBtnConfirm ("Toque | Botão: Confirmar Escolha"),
        toqueBtnCloseMoreDeta ("Toque | Botão: Fechar | Modal: Mais Detalhes"),
        toqueBtnClose ("Toque | Botão: Fechar"),
        toqueBtnTakePhoto ("Toque | Botão: Tirar Foto"),
        toqueoptions ("Toque | Opção: {0} | Valor: {1}"),
        toqueBtnPlano ("Toque | Botão: {0} | Plano: {1}"),
        erroMsgCampo ("Erro | Mensagem: {0} | Campo: {1}"),
        toqueMenu ("Toque | Menu: {0}"),
        toqueNotification ("Toque | Notificação: {0}"),
        toqueValorSugerido ("Toque | Valor Sugerido | Valor: {0}"),
        toqueBanco ("Toque | Banco: {0}"),
        toqueAba ("Toque | Aba: {0}"),
        swipeCards ("Swipe | Cartões"),
        swipeMoney ("Swipe | Moedas"),
        toqueAddress ("Toque | Endereço: {0}"),
        toqueBoleto ("Toque | Boleto: {0}");
    }


}
