package br.com.areadigital.backendmogodb.config.components;

import br.com.areadigital.backendmogodb.models.Person;
import br.com.areadigital.backendmogodb.restrepository.PersonRestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtTokenEnhancer implements TokenEnhancer {

	private final PersonRestRepository userRepository;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		Person user = userRepository.findByEmail(authentication.getName());

		Map<String, Object> map = new HashMap<>();
		map.put("userFirstName", user.getFirstname());
		map.put("userId", user.getId());

		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);

		return accessToken;
	}
}
