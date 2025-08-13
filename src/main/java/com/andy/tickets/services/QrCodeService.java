package com.andy.tickets.services;

import com.andy.tickets.domain.entities.QrCode;
import com.andy.tickets.domain.entities.Ticket;

public interface QrCodeService {
    QrCode generateQrCode(Ticket ticket);
}
