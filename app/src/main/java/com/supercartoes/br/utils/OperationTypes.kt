package com.supercartoes.br.utils

import com.supercartoes.br.R


class OperationTypes {

    fun getType(id: Long): OperationTypes.Types {

        var operation = OperationTypes.Types.default

        when (id) {

//        1.toLong() -> operation = OperationTypes.Types.taxaAdm
//        2.toLong() -> operation = OperationTypes.Types.cargaCelular
            3.toLong() -> operation = OperationTypes.Types.cargaPrePago
            4.toLong() -> operation = OperationTypes.Types.compraPrePago
            5.toLong() -> operation = OperationTypes.Types.pagamentoConta
//        6.toLong() -> operation = OperationTypes.Types.tarifaBancariaBoleto
//        7.toLong() -> operation = OperationTypes.Types.tarifaBancariaTEF
//        8.toLong() -> operation = OperationTypes.Types.tarifaBancariaTransferencia
//        9.toLong() -> operation = OperationTypes.Types.tarifaCargaPrePago
//        10.toLong() -> operation = OperationTypes.Types.tarifaTransferenciaExterna
            11.toLong() -> operation = OperationTypes.Types.transferenciaEntreBancos
            12.toLong() -> operation = OperationTypes.Types.transferencia
//        13.toLong() -> operation = OperationTypes.Types.tarifaPagamentoConta
            14.toLong() -> operation = OperationTypes.Types.transferenciaBancaria
//        15.toLong() -> operation = OperationTypes.Types.comissaoCorrespondenteBancario
//        16.toLong() -> operation = OperationTypes.Types.comissaoCargaCelular
//        17.toLong() -> operation = OperationTypes.Types.tarifaMensalContaCorrente
            18.toLong() -> operation = OperationTypes.Types.transferenciaSalario
            19.toLong() -> operation = OperationTypes.Types.saque
            21.toLong() -> operation = OperationTypes.Types.cargaCambioMoeda
            22.toLong() -> operation = OperationTypes.Types.cargaIntercap
//        23.toLong() -> operation = OperationTypes.Types.tarifaSaque
//        24.toLong() -> operation = OperationTypes.Types.tarifaRecargaCelular
//        25.toLong() -> operation = OperationTypes.Types.tarifaTransferenciaContaSuper
//        26.toLong() -> operation = OperationTypes.Types.creditoPromocional
//        27.toLong() -> operation = OperationTypes.Types.creditoFacebook
//        28.toLong() -> operation = OperationTypes.Types.perda
//        29.toLong() -> operation = OperationTypes.Types.contestacao
//        30.toLong() -> operation = OperationTypes.Types.devolucao
            31.toLong() -> operation = OperationTypes.Types.compraJogo
//        32.toLong() -> operation = OperationTypes.Types.premioLoteria
//        33.toLong() -> operation = OperationTypes.Types.tarifaProcessamento
//        34.toLong() -> operation = OperationTypes.Types.creditoIndicacao
            35.toLong() -> operation = OperationTypes.Types.tarifaSaqueInternacional
//        36.toLong() -> operation = OperationTypes.Types.saqueInternacional
//        37.toLong() -> operation = OperationTypes.Types.cargaCambioMoedaIOF
//        38.toLong() -> operation = OperationTypes.Types.repasseCorretora
//        39.toLong() -> operation = OperationTypes.Types.creditoLoterica
            40.toLong() -> operation = OperationTypes.Types.creditoRecargaCelular
            42.toLong() -> operation = OperationTypes.Types.transferenciaInterna
//        43.toLong() -> operation = OperationTypes.Types.tarifaMensalContaCorrenteParcial
//        44.toLong() -> operation = OperationTypes.Types.tarifaMensalPorCartao
//        45.toLong() -> operation = OperationTypes.Types.tarifaMensalPorCartaoParcial
//        46.toLong() -> operation = OperationTypes.Types.tarifaPromocaoContaSuper
//        47.toLong() -> operation = OperationTypes.Types.beneficiosNovosFuncionarios
//        48.toLong() -> operation = OperationTypes.Types.tarifaSempreFacil
//        49.toLong() -> operation = OperationTypes.Types.tarifaEmissaoCartaoVirtual
//        50.toLong() -> operation = OperationTypes.Types.tarifaCargaCambio
//        51.toLong() -> operation = OperationTypes.Types.tarifaEmissaoCartao
            53.toLong() -> operation = OperationTypes.Types.transferenciaInconsistente
//        54.toLong() -> operation = OperationTypes.Types.devolucaoTarifaContaSuper
//        55.toLong() -> operation = OperationTypes.Types.negativacaoDeConta
            56.toLong() -> operation = OperationTypes.Types.saqueTECBAN
//        57.toLong() -> operation = OperationTypes.Types.tarifaSaqueTECBAN
//        58.toLong() -> operation = OperationTypes.Types.tarifaSaldoTECBAN
//        59.toLong() -> operation = OperationTypes.Types.tarifaExtratoTECBAN
            60.toLong() -> operation = OperationTypes.Types.recargaBilheteTransporte
//        61.toLong() -> operation = OperationTypes.Types.impostosRecargaBilheteTransporte
//        64.toLong() -> operation = OperationTypes.Types.envioCartoes
//        65.toLong() -> operation = OperationTypes.Types.rePower
//        66.toLong() -> operation = OperationTypes.Types.tarifaRePower
//        67.toLong() -> operation = OperationTypes.Types.interchangeMastercard
//        68.toLong() -> operation = OperationTypes.Types.portabilidade
//        69.toLong() -> operation = OperationTypes.Types.saldo
//        70.toLong() -> operation = OperationTypes.Types.comissaoRecargaBilheteTransporte
            71.toLong() -> operation = OperationTypes.Types.cargaRecorrenteSantander
//        72.toLong() -> operation = OperationTypes.Types.vaquinhaOuRacharConta
            73.toLong() -> operation = OperationTypes.Types.transferenciaEntreContaSuperFOPA
//        74.toLong() -> operation = OperationTypes.Types.holerite
//        75.toLong() -> operation = OperationTypes.Types.microcreditoNatura

        }

        return operation

    }

    enum class Types(val title: Int, val img: Int) {

        //    taxaAdm(),
//    cargaCelular(),
        cargaPrePago(R.string.historic_tag_deposit, R.drawable.ic_cat_money),
        compraPrePago(R.string.historic_tag_card, R.drawable.ic_cat_credit_card),
        pagamentoConta(R.string.payments, R.drawable.ic_cat_payment),
        //    tarifaBancariaBoleto(),
//    tarifaBancariaTEF(),
//    tarifaBancariaTransferencia(),
//    tarifaCargaPrePago(),
//    tarifaTransferenciaExterna(),
        transferenciaEntreBancos(R.string.historic_tag_transfer, R.drawable.ic_cat_transfer),
        transferencia(R.string.historic_tag_transfer, R.drawable.ic_cat_transfer),
        //    tarifaPagamentoConta(),
        transferenciaBancaria(R.string.historic_tag_transfer, R.drawable.ic_cat_transfer),
        //    comissaoCorrespondenteBancario(),
//    comissaoCargaCelular(),
//    tarifaMensalContaCorrente(),
        transferenciaSalario(R.string.historic_tag_transfer, R.drawable.ic_cat_transfer),
        saque(R.string.historic_tag_cash_out, R.drawable.ic_cat_money),
        cargaCambioMoeda(R.string.historic_tag_exchange, R.drawable.ic_cat_exchange),
        cargaIntercap(R.string.historic_tag_deposit, R.drawable.ic_cat_money),
        //    tarifaSaque(),
//    tarifaRecargaCelular(),
//    tarifaTransferenciaContaSuper(),
//    creditoPromocional(),
//    creditoFacebook(),
//    perda(),
//    contestacao(),
//    devolucao(),
        compraJogo(R.string.historic_tag_card, R.drawable.ic_cat_credit_card),
        //    premioLoteria(),
//    tarifaProcessamento(),
//    creditoIndicacao(),
        tarifaSaqueInternacional(R.string.historic_tag_cash_out, R.drawable.ic_cat_money),
        //    saqueInternacional(),
//    cargaCambioMoedaIOF(),
//    repasseCorretora(),
//    creditoLoterica(),
        creditoRecargaCelular(R.string.historic_tag_phone_reload, R.drawable.ic_cat_phone_reload),
        transferenciaInterna(R.string.historic_tag_transfer, R.drawable.ic_cat_transfer),
        //    tarifaMensalContaCorrenteParcial(),
//    tarifaMensalPorCartao(),
//    tarifaMensalPorCartaoParcial(),
//    tarifaPromocaoContaSuper(),
//    beneficiosNovosFuncionarios(),
//    tarifaSempreFacil(),
//    tarifaEmissaoCartaoVirtual(),
//    tarifaCargaCambio(R.string.payments, R.drawable.ic_cat_payment),
//    tarifaEmissaoCartao(),
        transferenciaInconsistente(R.string.historic_tag_transfer, R.drawable.ic_cat_transfer),
        //    devolucaoTarifaContaSuper(),
//    negativacaoDeConta(),
        saqueTECBAN(R.string.historic_tag_cash_out, R.drawable.ic_cat_money),
        //    tarifaSaqueTECBAN(),
//    tarifaSaldoTECBAN(),
//    tarifaExtratoTECBAN(),
        recargaBilheteTransporte(R.string.historic_tag_reload, R.drawable.ic_cat_transport),
        //    impostosRecargaBilheteTransporte(),
//    envioCartoes(),
//    rePower(),
//    tarifaRePower(),
//    interchangeMastercard(),
//    portabilidade(),
//    saldo(),
//    comissaoRecargaBilheteTransporte(),
        cargaRecorrenteSantander(R.string.historic_tag_deposit, R.drawable.ic_cat_money),
        //    vaquinhaOuRacharConta(),
        transferenciaEntreContaSuperFOPA(R.string.historic_tag_transfer, R.drawable.ic_cat_transfer),
        //    holerite(),
//    microcreditoNatura(),
        default(R.string.others, R.drawable.ic_cat_more)

    }
}