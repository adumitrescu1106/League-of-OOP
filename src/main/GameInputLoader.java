package main;

import java.util.ArrayList;

import abilities.*;
import champions.*;
import fileio.FileSystem;


public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        int nDimension = 0;
        int mDimension = 0;
        ArrayList<ArrayList<Character>> arena = new ArrayList<ArrayList<Character>>();
        ArrayList<ArrayList<Character>> moves = new ArrayList<ArrayList<Character>>();
        ArrayList<Champion> players = new ArrayList<>();
        ArrayList<ArrayList<Ability>> spells = new ArrayList<ArrayList<Ability>>();
        int rounds = 0;
        int noChampions = 0;

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            nDimension = fs.nextInt();
            mDimension = fs.nextInt();

            for (int i = 0; i < nDimension; ++i) {
                String line = fs.nextWord();
                ArrayList<Character> newElements = new ArrayList<>();
                for (int j = 0; j < mDimension; ++j) {
                    newElements.add(line.charAt(j));
                }
                arena.add(newElements);
            }

            noChampions = fs.nextInt();

            for (int i = 0; i < noChampions; ++i) {
                String type = fs.nextWord();
                int x = fs.nextInt();
                int y = fs.nextInt();
                ArrayList<Ability> newSpells = new ArrayList<>();
                if (type.equals("W")) {
                    players.add(new Wizard(x, y, arena));
                    newSpells.add(new Drain());
                    newSpells.add(new Deflect());
                    spells.add(newSpells);
                }
                if (type.equals("K")) {
                    players.add(new Knight(x, y, arena));
                    newSpells.add(new Execute());
                    newSpells.add(new Slam());
                    spells.add(newSpells);
                }
                if (type.equals("P")) {
                    players.add(new Pyromancer(x, y, arena));
                    newSpells.add(new Fireblast());
                    newSpells.add(new Ignite());
                    spells.add(newSpells);
                }
                if (type.equals("R")) {
                    players.add(new Rogue(x, y, arena));
                    newSpells.add(new Backstab());
                    newSpells.add(new Paralysis());
                    spells.add(newSpells);
                }
            }
            rounds = fs.nextInt();
            for (int i = 0; i < rounds; ++i) {
                String line = fs.nextWord();
                ArrayList<Character> newElements = new ArrayList<>();
                for (int j = 0; j < players.size(); ++j) {
                    newElements.add(line.charAt(j));
                }
                moves.add(newElements);
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(rounds, arena, players, nDimension, mDimension, moves, spells);
    }
}
