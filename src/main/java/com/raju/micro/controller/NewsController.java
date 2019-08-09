package com.raju.micro.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.raju.micro.model.News;

@RestController
@RequestMapping("/news")
public class NewsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/template", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<News> callService(@RequestParam(required = true, name = "Country") String country,
			@RequestParam(required = true, name = "Category") String category,
			@RequestParam(required = false, name = "Keyword") String keyword) {
		LOGGER.info("calling service");
		String completeUrl = "https://newsapi.org/v2/top-headlines?apiKey=ccaf5d41cc5140c984818c344edcc14d&country="
				+ country + "&category=" + category + (keyword != null ? "Keyword=" + keyword : "");
		LOGGER.info("URL: " + completeUrl);
		String str = restTemplate.getForObject(completeUrl, String.class);
		LOGGER.info(str);
		Object obj;
		List<News> newsList = new ArrayList<>();
		try {
			obj = new JSONParser().parse(str);
			JSONObject jsonResult = (JSONObject) obj;
			JSONArray ja = (JSONArray) jsonResult.get("articles");
			Iterator itr2 = ja.iterator();
			Iterator<Map.Entry> itr1;
			while (itr2.hasNext()) {
				itr1 = ((Map) itr2.next()).entrySet().iterator();
				News news = new News(country, category, keyword);
				while (itr1.hasNext()) {
					Map.Entry pair = itr1.next();
					if (pair.getKey().equals("title")) {
						news.setNewsTitle(pair.getValue().toString());
					} else if (pair.getKey().equals("description")) {
						news.setDescription(pair.getValue().toString());
					} else if (pair.getKey().equals("url")) {
						news.setSourceNewsURL(pair.getValue().toString());
					}
				}
				newsList.add(news);
			}
			LOGGER.info("News size: " + newsList.size());
		} catch (ParseException e) {
			LOGGER.error("Exception occurred while processing the data");
			e.printStackTrace();
		}

		return newsList;
	}
}