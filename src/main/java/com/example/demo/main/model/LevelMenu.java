package com.example.demo.main.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LevelMenu {
	
	private Integer id;
	private String name;
	private Integer parentId;
	
	public static List<LevelMenu> gatLevelMenu() {
		
		LevelMenu lv1 = new LevelMenu(548, "化妝品", 0);
		LevelMenu lv2 = new LevelMenu(648, "日常用品", 0);
		LevelMenu lv3 = new LevelMenu(748, "男性用品", 0);
		
		LevelMenu lv4 = new LevelMenu(654, "眼線筆", 548);
		LevelMenu lv5 = new LevelMenu(655, "睫毛膏", 548);
		LevelMenu lv6 = new LevelMenu(656, "唇蜜", 548);
		
		LevelMenu lv7 = new LevelMenu(777, "衛生紙", 648);
		LevelMenu lv8 = new LevelMenu(778, "衣物清潔", 648);
		LevelMenu lv9 = new LevelMenu(779, "漱口水", 648);
		
		LevelMenu lv10 = new LevelMenu(811, "刮鬍刀", 748);
		LevelMenu lv11 = new LevelMenu(812, "男士洗面乳", 748);
		LevelMenu lv12 = new LevelMenu(813, "男士洗髮精", 748);
		
		LevelMenu lv13 = new LevelMenu(921, "凱婷 凝色柔滑眼線膠筆", 654);
		LevelMenu lv14 = new LevelMenu(922, "艾杜紗 魔束捲翹睫毛底膏", 655);
		LevelMenu lv15 = new LevelMenu(923, "CEZANNE 水潤光透染唇釉", 656);
		
		LevelMenu lv16 = new LevelMenu(1011, "舒潔棉柔舒適抽取衛生紙", 777);
		LevelMenu lv17 = new LevelMenu(1022, "白鴿天然尤加利防螨抗菌洗衣精", 778);
		LevelMenu lv18 = new LevelMenu(1023, "李施德霖天然綠茶防蛀護齦漱口水", 779);
		
		LevelMenu lv19 = new LevelMenu(2021, "舒適牌 水次元5 刮鬍刀", 811);
		LevelMenu lv20 = new LevelMenu(2022, "曼秀雷敦冰振活炭潔面乳", 812);
		LevelMenu lv21 = new LevelMenu(2023, "海倫仙度絲男士去屑洗髮乳", 813);
		
		List<LevelMenu> levelMenuList = new ArrayList<>();
		levelMenuList.add(lv1);
		levelMenuList.add(lv2);
		levelMenuList.add(lv3);
		levelMenuList.add(lv4);
		levelMenuList.add(lv5);
		levelMenuList.add(lv6);
		levelMenuList.add(lv7);
		levelMenuList.add(lv8);
		levelMenuList.add(lv9);
		levelMenuList.add(lv10);
		levelMenuList.add(lv11);
		levelMenuList.add(lv12);
		levelMenuList.add(lv13);
		levelMenuList.add(lv14);
		levelMenuList.add(lv15);
		levelMenuList.add(lv16);
		levelMenuList.add(lv17);
		levelMenuList.add(lv18);
		levelMenuList.add(lv19);
		levelMenuList.add(lv20);
		levelMenuList.add(lv21);
		
		return levelMenuList;
	}
}


