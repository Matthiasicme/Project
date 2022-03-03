package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClothingGenerator {

    public List<Clothing> getAllClothes  () {
        List<Clothing> results = new ArrayList<>();
        results.add(new Clothing(Clothing.Type.HEADGEAR));
        return results;
    }
}
