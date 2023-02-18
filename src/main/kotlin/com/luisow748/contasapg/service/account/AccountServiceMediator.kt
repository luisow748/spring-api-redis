package com.luisow748.contasapg.service.account

import com.luisow748.contasapg.domain.Account
import com.luisow748.contasapg.service.installment.InstallmentServiceMediator
import org.springframework.stereotype.Service

@Service
class AccountServiceMediator(
    val dateAccountService: DateAccountService,
    val installmentServiceMediator: InstallmentServiceMediator
) {
    lateinit var account: Account
    fun setCreationDate() {
        dateAccountService.setCreatedDate(this.account)
    }

    fun setExpirationDate(){
        dateAccountService.setExpirationDate(this.account)
    }
    fun prepareAccount(account: Account) {
        this.account = account
        installmentServiceMediator.setInstallments(account)
        setCreationDate()
        setExpirationDate()
    }
}