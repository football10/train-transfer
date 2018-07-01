package org.traintransfer.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.traintransfer.common.Constants;
import org.traintransfer.response.OpenIdResponse;
import org.traintransfer.response.model.OpenIdInfo;

import com.google.gson.Gson;

@Service
@Transactional
public class OpenIdService {

	static final Logger log = LoggerFactory.getLogger(OpenIdService.class);

	public String getOpenId(String code) {

		OpenIdResponse response = new OpenIdResponse();
		Gson gson = new Gson();

		try {
			StringBuffer result = new StringBuffer();

			StringBuilder urlPath = new StringBuilder(Constants.OPENID_URL);
			urlPath.append(String.format("?appid=%s", Constants.APPID));
			urlPath.append(String.format("&secret=%s", Constants.SECRET));
			urlPath.append(String.format("&js_code=%s", code));
			urlPath.append(String.format("&grant_type=%s", "authorization_code")); // 固定值

			URL url = new URL(urlPath.toString());
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setDoOutput(true);
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;");

			con.connect();
			final int status = con.getResponseCode();
			if (status == HttpURLConnection.HTTP_OK) {
				final InputStream in = con.getInputStream();
				String encoding = con.getContentEncoding();
				if(null == encoding) {
					encoding = "UTF-8";
				}
				final InputStreamReader inReader = new InputStreamReader(in, encoding);
				final BufferedReader bufReader = new BufferedReader(inReader);
				String line = null;
				while((line = bufReader.readLine()) != null) {
					result.append(line);
				}
				bufReader.close();
				inReader.close();
				in.close();
			} else {
				throw new IllegalStateException("Weixin API connect failed, Status : "+ status);
			}

			response.result = gson.fromJson(result.toString(), OpenIdInfo.class);
			response.responseCode = Constants.RESPONSE_CODE_OK;
		} catch (Exception e) {
			e.printStackTrace();
			response.result = null;
			response.responseCode = Constants.RESPONSE_CODE_NG;

			log.error(e.getMessage(), e);
		}

		String json = gson.toJson(response);
		log.info("GetOpenIdResponse = " + json);

		return json;
	}

}