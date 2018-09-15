package org.traintransfer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CoreService {

	static final Logger log = LoggerFactory.getLogger(CoreService.class);

	public String getTransferList(String jsonRequest) {
		return "";
	}
}
