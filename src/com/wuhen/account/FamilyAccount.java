package com.wuhen.account;

public class FamilyAccount {

	// 标记程序是否退出
	static boolean isFlag = true;
	// 初始金额
	static int balance = 0;
	// 收入
	static int addMoney;
	// 用于记录收入和支出的详情
	static String details = "收支\t账户金额\t收支金额\t说  明\n";

	/**
	 * 	主方法，程序执行入口
	 */
	public static void main(String[] args) {
		while (isFlag) {
			menu();
			choose();
		}
	}

	/**
	 * 	主菜单界面
	 */
	private static void menu() {
		System.out.println("------家庭收支记账软件------\n");
		System.out.println("\t  1  收支明细       \t");
		System.out.println("\t  2  登记收入       \t");
		System.out.println("\t  3  登记支出       \t");
		System.out.println("\t  4  退        出       \t\n");
		System.out.print("\t  请选择( 1-4 )：");
	}

	/**
	 *	用户选择
	 */
	private static void choose() {
		// 获取用户的选择：1-4
		char selection = Utility.readMenuSelection();
		switch (selection) {
		case '1':
			System.out.println("------当前收支明细记录------");
			System.out.println(details);
			System.out.println("----------------------------\n");
			break;
		case '2':
			add();
			break;
		case '3':
			minus();
			break;
		case '4':
			exit();
		}
	}

	/**
	 * 	收入登记功能
	 */
	private static void add() {
		System.out.print("请输入收入金额（大于0的整数）： ");
		addMoney = Utility.readNumber();
		if (addMoney > 0) {
			System.out.print("本次收入说明： ");
			String addInfo = Utility.readString();
			System.out.println("----------登记完成----------\n");

			// 收入入账计算
			balance += addMoney;

			// 更新收支明细
			details += "收入\t" + balance + "\t" + addMoney + "\t" + addInfo + "\n";
		} else if (addMoney == 0) {
			System.out.println("都 0 收入了还不快去找工作赚钱！");
		} else {
			add();
		}
	}

	/**
	 * 	支出登记功能
	 */
	private static void minus() {
		System.out.print("请输入支出金额（大于0的整数）： ");
		int minusMoney = Utility.readNumber();
		if (minusMoney > 0) {
			System.out.print("本次支出说明： ");
			String minusInfo = Utility.readString();

			// 支出计算
			if (balance >= minusMoney) {
				balance -= minusMoney;
				// 更新支出明细
				details += "支出\t" + balance + "\t" + minusMoney + "\t" + minusInfo + "\n";
				System.out.println("----------登记完成----------\n");
			} else {
				System.out.println("支出超出账户余额，支付失败！");
			}
		} else if (minusMoney == 0) {
			System.out.println("0 支出真节俭！");
		} else {
			//输入的支出不是大于等于0  的数字，再执行一次支出登记功能
			minus();
		}
	}

	/**
	 * 	标记程序是否退出
	 */
	private static void exit() {
		System.out.print("\t 确认是否退出（Y/y/N/n） ： ");
		char isExit = Utility.readConfirmSelection();
		if (isExit == 'Y') {
			isFlag = false;
		}
	}
}