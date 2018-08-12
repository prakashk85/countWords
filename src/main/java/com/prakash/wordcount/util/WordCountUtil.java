package com.prakash.wordcount.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.prakash.wordcount.bean.Word;

public class WordCountUtil {

	public static Map<String, Integer> getWordCountMap(String para, List<Word> inputWords) {
		Map<String, Integer> mapWordCount = getWordCountMap(para);
		Map<String, Integer> mapResult = new LinkedHashMap<>();

		for (Word word : inputWords) {

			if (mapWordCount.containsKey(word.getWord())) {
				mapResult.put(word.getWord(), mapWordCount.get(word.getWord()));
			} else {
				mapResult.put(word.getWord(), 0);
			}

		}
		return mapResult;
	}

	public static List<Entry<String, Integer>> getTopList(String para, int count) {
		List<Entry<String, Integer>> listEntries = new ArrayList<>(getWordCountMap(para).entrySet());

		Collections.sort(listEntries, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		if (count > listEntries.size())
			count = listEntries.size();

		return listEntries.subList(0, count);
	}

	private static Map<String, Integer> getWordCountMap(String s) {
		List<String> listWords = Arrays.asList(s.split("[\\p{Punct}\\s]+"));
		Set<String> setUniqueWords = new HashSet<>(listWords);
		Map<String, Integer> mapWordCount = new HashMap<>();

		for (String word : setUniqueWords) {
			mapWordCount.put(word, Collections.frequency(listWords, word));
		}

		return mapWordCount;
	}
}