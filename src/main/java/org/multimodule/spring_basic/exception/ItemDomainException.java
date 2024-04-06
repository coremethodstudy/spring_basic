package org.multimodule.spring_basic.exception;

public class ItemDomainException extends DomainException {
    public ItemDomainException(String message) {
        super(message);
    }

    public ItemDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
