package com.test.util.util;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangnan
 * @date 2019/11/05 14:36
 */
public class UtilMain {

    private static String content = "435418\n" +
            "435419\n" +
            "435420\n" +
            "435423\n" +
            "435425\n" +
            "435434\n" +
            "435436\n" +
            "435437\n" +
            "435438\n" +
            "435442\n" +
            "435443\n" +
            "435447\n" +
            "435454\n" +
            "435457\n" +
            "435458\n" +
            "435463\n" +
            "435464\n" +
            "435465\n" +
            "435471\n" +
            "435474\n" +
            "435476\n" +
            "435478\n" +
            "435480\n" +
            "435482\n" +
            "435484\n" +
            "435486\n" +
            "435488\n" +
            "435492\n" +
            "435494\n" +
            "435495\n" +
            "435498\n" +
            "435499\n" +
            "435500\n" +
            "435501\n" +
            "435502\n" +
            "435503\n" +
            "435504\n" +
            "435505\n" +
            "435508\n" +
            "435510\n" +
            "435512\n" +
            "435514\n" +
            "435516\n" +
            "435518\n" +
            "435520\n" +
            "435522\n" +
            "435523\n" +
            "435524\n" +
            "435526\n" +
            "435527\n" +
            "435529\n" +
            "435530\n" +
            "435531\n" +
            "435532\n" +
            "435533\n" +
            "435534\n" +
            "435535\n" +
            "435536\n" +
            "435537\n" +
            "435538\n" +
            "435539\n" +
            "435540\n" +
            "435541\n" +
            "435542\n" +
            "435543\n" +
            "435544\n" +
            "435545\n" +
            "435546\n" +
            "435547\n" +
            "435548\n" +
            "435549\n" +
            "435550\n" +
            "435551\n" +
            "435552\n" +
            "435553\n" +
            "435554\n" +
            "435556\n" +
            "435557\n" +
            "435559\n" +
            "435560\n" +
            "435561\n" +
            "435562\n" +
            "435563\n" +
            "435564\n" +
            "435566\n" +
            "435567\n" +
            "435568\n" +
            "435569\n" +
            "435570\n" +
            "435573\n" +
            "435574\n" +
            "435575\n" +
            "435576\n" +
            "435577\n" +
            "435579\n" +
            "435580\n" +
            "435581\n" +
            "435582\n" +
            "435583\n" +
            "435584\n" +
            "435585\n" +
            "435587\n" +
            "435588\n" +
            "435589\n" +
            "435590\n" +
            "435591\n" +
            "435592\n" +
            "435593\n" +
            "435594\n" +
            "435595\n" +
            "435596\n" +
            "435597\n" +
            "435598\n" +
            "435599\n" +
            "435601\n" +
            "435605\n" +
            "435606\n" +
            "435607\n" +
            "435608\n" +
            "435610\n" +
            "435611\n" +
            "435612\n" +
            "435613\n" +
            "435614\n" +
            "435615\n" +
            "435616\n" +
            "435617\n" +
            "435618\n" +
            "435619\n" +
            "435620\n" +
            "435621\n" +
            "435622\n" +
            "435623\n" +
            "435624\n" +
            "435626\n" +
            "435628\n" +
            "435629\n" +
            "435630\n" +
            "435631\n" +
            "435632\n" +
            "435633\n" +
            "435635\n" +
            "435636\n" +
            "435639\n" +
            "435640\n" +
            "435643\n" +
            "435644\n" +
            "435645\n" +
            "435649\n" +
            "435650\n" +
            "435651\n" +
            "435652\n" +
            "435654\n" +
            "435659\n" +
            "435661\n" +
            "435662\n" +
            "435665\n" +
            "435667\n" +
            "435669\n" +
            "435671\n" +
            "435673\n" +
            "435677\n" +
            "435679\n" +
            "435680\n" +
            "435681\n" +
            "435682\n" +
            "435683\n" +
            "435684\n" +
            "435685\n" +
            "435686\n" +
            "435687\n" +
            "435693\n" +
            "435696\n" +
            "435697\n" +
            "435699\n" +
            "435700\n" +
            "435703\n" +
            "435708\n" +
            "435710\n" +
            "435711\n" +
            "435712\n" +
            "435713\n" +
            "435716\n" +
            "435717\n" +
            "435720\n" +
            "435721\n" +
            "435723\n" +
            "435724\n" +
            "435726\n" +
            "435728\n" +
            "435729\n" +
            "435730\n" +
            "435733\n" +
            "435736\n" +
            "435739\n" +
            "435742\n" +
            "435743\n" +
            "435745\n" +
            "435748\n" +
            "435750\n" +
            "435751\n" +
            "435752\n" +
            "435753\n" +
            "435756\n" +
            "435757\n" +
            "435758\n" +
            "435759\n" +
            "435760\n" +
            "435761\n" +
            "435762\n" +
            "435764\n" +
            "435765\n" +
            "435766\n" +
            "435771\n" +
            "435772\n" +
            "435773\n" +
            "435774\n" +
            "435776\n" +
            "435777\n" +
            "435778\n" +
            "435779\n" +
            "435781\n" +
            "435782\n" +
            "435785\n" +
            "435787\n" +
            "435789\n" +
            "435791\n" +
            "435793\n" +
            "435795\n" +
            "435797\n" +
            "435799\n" +
            "435800\n" +
            "435801\n" +
            "435805\n" +
            "435808\n" +
            "435810\n" +
            "435812\n" +
            "435815\n" +
            "435820\n" +
            "435822\n" +
            "435824\n" +
            "435827\n" +
            "435828\n" +
            "435829\n" +
            "435830\n" +
            "435832\n" +
            "435833\n" +
            "435836\n" +
            "435838\n" +
            "435841\n" +
            "435842\n" +
            "435845\n" +
            "435846\n" +
            "435848\n" +
            "435851\n" +
            "435854\n" +
            "435858\n" +
            "435883\n" +
            "435885\n" +
            "435887\n" +
            "435889\n" +
            "435893\n" +
            "435899\n" +
            "435901\n" +
            "435904";

    public static void main(String[] args) {
        handleSkuId();
    }

    private void handleThirdCat() {
        String[] contents = content.split("\n");

        Map<String, List<String>> thirdIdMap = new HashMap<>();
        Map<String, List<String>> thirdNameMap = new HashMap<>();

        for (String s : contents) {
            LineData lineData = handleLine(s);
            if (!thirdIdMap.containsKey(lineData.getThirdId().toString())) {
                thirdIdMap.put(lineData.getThirdId().toString(), new ArrayList<>());
            }
            thirdIdMap.get(lineData.getThirdId().toString()).add(lineData.getSkuId().toString());

            if (!thirdNameMap.containsKey(handleName(lineData.getThirdName()))) {
                thirdNameMap.put(handleName(lineData.getThirdName()), new ArrayList<>());
            }
            thirdNameMap.get(handleName(lineData.getThirdName())).add(lineData.getSkuId().toString());
        }

        StringBuilder idData = new StringBuilder("\t\t\t(CASE \n");
        thirdIdMap.entrySet().forEach(entry -> handleItem(idData, entry));
        idData.append("\t\t\tEND)");

        StringBuilder nameData = new StringBuilder("\t\t\t(CASE \n");
        thirdNameMap.entrySet().forEach(entry -> handleItem(nameData, entry));
        nameData.append("\t\t\tEND)");

        System.out.println(idData.toString());
        System.out.println("\n\n");
        System.out.println(nameData.toString());
    }

    private static String handleName(String name) {
        return "'" + name + "'";
    }

    private static LineData handleLine(String line) {
        String[] fields = line.split("\t");
        Integer skuId = Integer.parseInt(fields[0]);
        Integer thirdId = Integer.parseInt(fields[1]);
        return new LineData(skuId, thirdId, fields[2]);
    }

    private static void handleItem(StringBuilder builder, Map.Entry<String, List<String>> entry) {
        builder.append("\t\t\t\tWHEN sku_id in (");
        builder.append(String.join(",", entry.getValue()));
        builder.append(") THEN\n\t\t\t\t");
        builder.append(entry.getKey());
        builder.append("\n");
    }

    private static void handleSkuId() {
        String[] contents = content.split("\n");

        StringBuilder data = new StringBuilder();
        for (String s : contents) {
            data.append(s);
            data.append(",");
        }
        System.out.println(data.toString());
    }
}
