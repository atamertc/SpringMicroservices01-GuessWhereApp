package com.atamertc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Getter
public enum ErrorType {

    USERNAME_EXIST(4110,"Kullanici zaten mevcut", HttpStatus.BAD_REQUEST),
    USER_NOT_CREATED(4111,"Kullanici olusturulamadi",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4112,"Boyle bir kullanici bulunamadi",HttpStatus.BAD_REQUEST),
    CITY_NOT_FOUND(4112,"Boyle bir sehir bulunamadi",HttpStatus.BAD_REQUEST),
    USERNAME_OR_PASSWORD_INCORRECT(1001, "Kullanici adi veya sifre hatali.", HttpStatus.BAD_REQUEST),
    REGISTER_PASSWORD_MISMATCH(1002, "Girilen parolalar uyusmadi.", HttpStatus.NOT_FOUND),
    REGISTER_USERNAME_EXIST(1003, "Bu kullanici adi daha once alinmis.", HttpStatus.NOT_FOUND),
    ACTIVATION_CODE_MISMATCH(4113,"Aktivasyon kodunuz uyusmadi",HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4114,"Kullanici adi veya sifre hatali",HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4115,"Aktive Edilmemis hesap. Lutfen hesabinizi aktif hale getirin" ,HttpStatus.FORBIDDEN),
    INVALID_TOKEN(4116,"Gecersiz token" ,HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4117,"Token olusturulamadi" ,HttpStatus.BAD_REQUEST),
    PERSONAL_EMAIL_IS_TAKEN(4118,"Bu email sistemde kayitli" ,HttpStatus.BAD_REQUEST),
    INSUFFICIENT_PERMISSION(4119, "Bu islemi yapmaya yetkiniz yok", HttpStatus.BAD_REQUEST),
    USER_TYPE_MISMATCH(12324,"Kullanicinin tipi bu istege uygun degildir.",HttpStatus.BAD_REQUEST),
    COULD_NOT_DELETE_ALL_USERS(12324,"Kullanicilarin hepsi silinemedi.",HttpStatus.BAD_REQUEST),
    COULD_NOT_UPDATE_ALL_USERS(12324,"Kullanicilarin hepsi guncellenmedi.",HttpStatus.BAD_REQUEST),
    COMPANY_NAME_OR_TAX_NO_IS_NOT_VALID(12324,"Sirket adi veya vergi numarasi sistemde mevcut. Lutfen kendinize ait sirket ismi veya vergi numarasi giriniz",HttpStatus.BAD_REQUEST),


    INTERNAL_ERROR_SERVER(5100,"Sunucu Hatasi",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100, "Parametre hatasi", HttpStatus.BAD_REQUEST);

    private int code;
    private String message;
    HttpStatus status;
}
