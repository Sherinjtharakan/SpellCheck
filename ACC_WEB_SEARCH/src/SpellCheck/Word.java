package SpellCheck;

public class Word {

        private final String word;
        private int similarityValue;

        Word(String word){
            this.word = word;
        }

        public String getWord() {
            return word;
        }

        public int getSimilarityValue() {
            return similarityValue;
        }

        public void setSimilarityValue(int similarityValue) {
        this.similarityValue = similarityValue;
        }
}
