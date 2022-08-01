package SpellCheck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SpellCheck {

    private List<Word> FetchSimilar(String target, List<String> dictionary){
        Word word;
        EditDistance editDistance;
        List<Word> words = new ArrayList<>();
        for (int i = 0; i < dictionary.size(); i++) {
            String string = dictionary.get(i);
            word = new Word(string);
            editDistance = new EditDistance();
            word.setSimilarityValue(editDistance.fetchSimilarity(target,string));
            words.add(word);
        }
        return words;
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList();
        dictionary.add("the");
        dictionary.add("there");
        dictionary.add("that");
        dictionary.add("cat");
        dictionary.add("mat");
        dictionary.add("his");
        dictionary.add("berry");
        dictionary.add("cherry");
        dictionary.add("perry");
        dictionary.add("ferry");
        dictionary.add("kitty");
        dictionary.add("katty");
        dictionary.add("sherry");
        
        String target = "sherin";

        SpellCheck spellCheck = new SpellCheck();
        List<Word> output = spellCheck.FetchSimilar(target,dictionary);
        output.sort(Comparator.comparing(Word::getSimilarityValue));


        int maxShow = 3;
        System.out.println("You entered "+target+" Did you mean: ");

        for (int i = 0; i < output.size(); i++) {
            if(output.get(i).getSimilarityValue()>maxShow)
                break;
            else
                System.out.print(output.get(i).getWord()+" ");
        }

    }
}
