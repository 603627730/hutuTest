//
//package com.alaeat.aio.payment.domain.chargeback;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import com.alaeat.aio.payment.domain.apple.ApplePaymentRepository;
//import com.alaeat.aio.payment.domain.creditcard.CreditCardPaymentRepository;
//import com.alaeat.aio.payment.domain.google.GooglePaymentRepository;
//import com.alaeat.aio.payment.domain.settlement.account.repo.ProcessAccountRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import com.alaeat.aio.payment.app.settlement.command.ProcessBillingCmd;
//import com.alaeat.aio.payment.domain.chargeback.detail.ChargeBackDetail;
//import com.alaeat.aio.payment.domain.chargeback.detail.ChargeBackDetailRepo;
//import com.alaeat.aio.payment.domain.instance.entity.PaymentGateWayEnum;
//import com.alaeat.aio.payment.domain.payment.PaymentRepository;
//import com.alaeat.aio.payment.domain.payment.entity.Payment;
//import com.alaeat.aio.payment.vo.Billing;
//import com.alaeat.aio.payment.vo.BuyerInfo;
//import io.ubt.bus.util.RRID;
//import org.springframework.beans.factory.annotation.Autowired;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ChargeBackDomainServiceTest {
//
//    @Mock
//    private ChargeBackRepo chargeBackRepo;
//    @Mock
//    private PaymentRepository paymentRepository;
//
//    @Mock
//    private ApplePaymentRepository applePaymentRepository;
//
//    @Mock
//    private GooglePaymentRepository googlePaymentRepository;
//
//    @Mock
//    private CreditCardPaymentRepository creditCardPaymentRepository;
//
//    @Mock
//    private ProcessAccountRepository processAccountRepository;
//
//    @InjectMocks
//    private ChargeBackDomainService chargeBackDomainServiceUnderTest;
//
//    @Before
//    public void before() {
//        RRID.init(1234);
//    }
//
////    @Test
////    public void testCreate() {
////        // Setup
////        final ProcessBillingCmd expectedResult = new ProcessBillingCmd();
////        expectedResult.setInstanceId(0L);
////        expectedResult.setRefId(0L);
////        expectedResult.setSourceMerchant(0L);
////        expectedResult.setBillingMode(0);
////        expectedResult.setPaymentMethod(0);
////        expectedResult.setGatewayType(0);
////        final Billing billing = new Billing();
////        billing.setMerchantId(0L);
////        billing.setAmount(0L);
////        billing.setFundsMenu(0);
////        billing.setSeq(0);
////        billing.setDisabled(false);
////        expectedResult.setBillings(Arrays.asList(billing));
////        final BuyerInfo buyerInfo = new BuyerInfo();
////        buyerInfo.setBuyerId(0L);
////        buyerInfo.setName("name");
////        expectedResult.setBuyerInfo(buyerInfo);
////
////        // Configure PaymentRepository.findByTransactionId(...).
////        final List<Payment> payments = Arrays.asList(Payment.builder().id(0L).instanceId(0L).merchantId(0L).buyerId(0L).buyer("name")
////            .gatewayType(PaymentGateWayEnum.PAYRIX).build());
////        when(mockPaymentRepository.findByTransactionId("txnId")).thenReturn(payments);
////
////        // Configure ChargeBackRepo.findByTransactionId(...).
////        final ChargeBack chargeBack =
////            new ChargeBack(0L, "transactionId", "txnId", "merchant", "code", "reason", 0, "cardBrand", 0L, "cycle");
////        when(mockRepo.findByTransactionId("transactionId")).thenReturn(chargeBack);
////
////        // Configure ChargeBackDetailRepo.findByChargebackId(...).
////        final List<ChargeBackDetail> chargeBackDetails =
////            Arrays.asList(new ChargeBackDetail(0L, 0L, 0L, "merchant", 0, "transactionId", "subject", "cycle"));
////
////        when(mockRepo.save(any(ChargeBack.class))).thenReturn(0L);
////
////        // Configure ChargeBackDetailRepo.findByChargebackIdAndStatus(...).
////        final ChargeBackDetail chargeBackDetail = new ChargeBackDetail(0L, 0L, 0L, "merchant", 0, "transactionId", "subject", "cycle");
////
////        // Run the test
////        final ProcessBillingCmd result = chargeBackDomainServiceUnderTest.create("transactionId", "txnId", "merchant", "code", "reason",
////            "Open", "cardBrand", 0L, "subject", "cycle");
////
////    }
//
//
//    @Test
//    public
//}
