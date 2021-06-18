package otherthanleetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SubsequenceRemoval {

	public static void main(String[] args) {
		int a[] = { 886362, 556289, 366488, 558429, 128591, 631731, 824238, 662012, 652496, 827479, 856120, 12372,
				654525, 557902, 998851, 456702, 574187, 668750, 422220, 904428, 428898, 369889, 855302, 450657, 902815,
				516516, 291352, 157941, 143635, 577225, 756124, 88018, 631841, 972117, 764130, 887674, 434084, 128482,
				950058, 537022, 246567, 582750, 442030, 964104, 117483, 788939, 159126, 999250, 160420, 31613, 227009,
				414445, 890428, 388127, 952131, 14204, 367823, 290350, 730849, 151798, 421806, 15100, 13783, 703079,
				873244, 854382, 869074, 645167, 275284, 102015, 889783, 379521, 838593, 152443, 784218, 371622, 80515,
				333573, 10120, 769912, 858481, 637009, 182589, 361511, 475410, 784362, 210030, 430519, 932771, 240749,
				757313, 506240, 666516, 770444, 438928, 855085, 333131, 165453, 856234, 143998, 521503, 231753, 114386,
				946822, 427550, 54637, 530046, 992877, 714567, 879484, 220441, 788526, 623249, 33226, 545537, 531866,
				985315, 840323, 98634, 160212, 591641, 200546, 692793, 271508, 598918, 852026, 942025, 729636, 187948,
				884721, 167466, 628966, 621701, 677184, 586749, 478667, 856766, 588276, 463705, 996253, 770935, 957936,
				688201, 801078, 585540, 191913, 399692, 645447, 522351, 622888, 869332, 16338, 811891, 961292, 619975,
				311409, 728258, 264069, 464769, 424141, 130433, 603482, 628368, 72615, 977415, 414692, 514039, 546514,
				890209, 298897, 407979, 208630, 529937, 301602, 546073, 846159, 489802, 541677, 820830, 7917, 882294,
				871963, 415821, 559986, 140080, 33899, 228589, 107543, 983178, 635758, 864377, 445542, 414281, 77641,
				683294, 290817, 738468, 163062, 316416, 300762, 38984, 819459, 132725, 45881, 441495, 698449, 154120,
				172922, 360740, 961110, 149304, 107532, 995384, 160988, 658678, 264563, 443857, 149247, 854891, 952390,
				367454, 518963, 546095, 689521, 503236, 951036, 701267, 489013, 75036, 820789, 517720, 639971, 149042,
				965322, 576566, 403173, 81288, 702205, 382230, 235829, 414609, 147300, 240600, 171812, 507894, 343529,
				745550, 821141, 33748, 484169, 494335, 821311, 976636, 735638, 289573, 641134, 216626, 277813, 629039,
				982594, 233007, 646113, 739392, 815854, 794655, 824486, 239214, 18490, 18276, 63078, 479236, 549570,
				597393, 218776, 446016, 131638, 991343, 66436, 979862, 818520, 126971, 187656, 488427, 512448, 787366,
				836694, 108314, 688539, 118804, 850547, 178419, 942120, 808414, 663994, 621495, 53242, 691984, 14103,
				246749, 803833, 337451, 48141, 680401, 424160, 148580, 267633, 230447, 34496, 111139, 274732, 625804,
				111996, 42117, 730172, 660718, 670411, 124763, 86515, 849103, 573434, 755689, 477943, 116830, 302439,
				697192, 586881, 403325, 578247, 762756, 679710, 671044, 561760, 781982, 239281, 494589, 681936, 131851,
				105903, 883942, 76740, 865747, 890657, 657778, 594050, 463987, 726949, 422088, 792224, 248027, 869038,
				628290, 865930, 172657, 655744, 381744, 155648, 994125, 607029, 776659, 875733, 381563, 487354, 929954,
				230321, 590780, 196370, 823176, 858000, 645828, 810578, 628067, 346626, 785661, 545507, 623687, 439401,
				537795, 159236, 530873, 875901, 507751, 468550, 433973, 286539, 130605, 851918, 678185, 793394, 525,
				455574, 10487, 916069, 703925, 363563, 351031, 12908, 441669, 416752, 123890, 391202, 231825, 111835,
				297128, 325432, 983843, 382003, 966091, 850865, 113527, 872152, 732802, 806628, 480382, 127483, 503975,
				374910, 392155, 656289, 296073, 928445, 994729, 631012, 40683, 901557, 364722, 139570, 644995, 485263,
				853177, 431052, 111292, 990469, 109426, 235528, 890548, 68264, 800325, 629712, 510015, 777626, 84430,
				438561, 943906, 844180, 277216, 502925, 79321, 950113, 701309, 390393, 443345, 712161, 564831, 115488,
				521838, 382472, 60403, 130126, 728711, 419612, 371993, 324901, 399333, 468410, 166181, 835547, 32264,
				375377, 84321, 732858, 492130, 79525, 125449, 238880, 449561, 722254, 424333, 432061, 238473, 827830,
				469970, 227159, 944704, 56543, 731826, 862536, 111169, 48411, 118967, 87807, 27266, 398354, 267108,
				300475, 396077, 11903, 420140, 160980, 777634, 671155, 3, 13, 32, 55, 58, 60, 67, 72, 86, 109, 116, 124,
				132, 133, 136, 144, 146, 175, 176, 176, 186, 201, 208, 213, 222, 236, 237, 238, 245, 255, 292, 297, 304,
				328, 337, 339, 348, 349, 351, 386, 397, 402, 403, 407, 414, 414, 418, 431, 437, 444, 447, 468, 473, 476,
				478, 482, 486, 493, 496, 502, 506, 529, 539, 549, 552, 553, 555, 568, 594, 602, 604, 616, 621, 638, 651,
				689, 692, 694, 696, 697, 708, 711, 734, 736, 767, 773, 803, 812, 813, 817, 820, 831, 836, 841, 844, 849,
				858, 860, 861, 872, 875, 877, 896, 909, 909, 917, 923, 928, 945, 967, 971, 978, 1009, 1012, 1013, 1015,
				1023, 1024, 1028, 1035, 1037, 1050, 1060, 1072, 1094, 1096, 1111, 1114, 1135, 1152, 1153, 1159, 1167,
				1168, 1171, 1173, 1196, 1196, 1199, 1224, 1226, 1232, 1247, 1250, 1254, 1277, 1297, 1315, 1316, 1330,
				1340, 1344, 1350, 1351, 1352, 1357, 1365, 1367, 1376, 1377, 1382, 1407, 1429, 1434, 1447, 1475, 1494,
				1499, 1504, 1505, 1520, 1520, 1540, 1560, 1571, 1574, 1584, 1585, 1595, 1599, 1600, 1609, 1612, 1620,
				1623, 1626, 1630, 1634, 1646, 1676, 1681, 1682, 1692, 1705, 1705, 1721, 1723, 1730, 1736, 1738, 1752,
				1754, 1758, 1767, 1776, 1777, 1781, 1790, 1797, 1814, 1818, 1820, 1828, 1848, 1848, 1877, 1885, 1892,
				1932, 1955, 1960, 1969, 1984, 2004, 2005, 2005, 2032, 2059, 2082, 2084, 2128, 2129, 2174, 2176, 2195,
				2199, 2207, 2220, 2225, 2236, 2246, 2254, 2257, 2258, 2271, 2286, 2289, 2293, 2297, 2318, 2380, 2386,
				2390, 2393, 2398, 2409, 2416, 2423, 2428, 2444, 2463, 2465, 2468, 2475, 2477, 2515, 2520, 2523, 2531,
				2538, 2542, 2569, 2592, 2600, 2633, 2658, 2662, 2679, 2698, 2708, 2730, 2732, 2735, 2737, 2758, 2773,
				2774, 2778, 2785, 2794, 2799, 2800, 2810, 2815, 2817, 2834, 2854, 2862, 2867, 2878, 2880, 2881, 2916,
				2944, 2978, 2984, 2987, 3006, 3015, 3052, 3053, 3056, 3059, 3064, 3077, 3082, 3083, 3083, 3086, 3109,
				3125, 3127, 3133, 3151, 3157, 3169, 3172, 3183, 3185, 3187, 3188, 3207, 3208, 3216, 3216, 3217, 3220,
				3246, 3249, 3257, 3263, 3278, 3354, 3354, 3396, 3400, 3409, 3420, 3451, 3463, 3484, 3484, 3491, 3499,
				3507, 3528, 3535, 3536, 3565, 3572, 3577, 3578, 3587, 3588, 3592, 3600, 3604, 3605, 3615, 3615, 3620,
				3624, 3638, 3641, 3648, 3652, 3672, 3682, 3684, 3704, 3737, 3742, 3742, 3756, 3787, 3791, 3791, 3792,
				3795, 3796, 3813, 3836, 3840, 3874, 3884, 3890, 3899, 3900, 3901, 3920, 3939, 3940, 3941, 3949, 3954,
				3971, 3980, 3995, 4003, 4007, 4015, 4031, 4043, 4067, 4072, 4086, 4089, 4090, 4094, 4101, 4110, 4113,
				4117, 4117, 4130, 4132, 4167, 4179, 4180, 4201, 4206, 4209, 4233, 4234, 4240, 4244, 4261, 4270, 4273,
				4278, 4282, 4292, 4301, 4325, 4327, 4331, 4343, 4364, 4364, 4376, 4377, 4380, 4395, 4400, 4405, 4412,
				4415, 4420, 4423, 4423, 4432, 4434, 4438, 4449, 4449, 4455, 4465, 4468, 4483, 4486, 4492, 4512, 4513,
				4516, 4521, 4524, 4538, 4549, 4555, 4564, 4570, 4591, 4597, 4620, 4626, 4655, 4658, 4669, 4678, 4681,
				4684, 4687, 4689, 4704, 4723, 4726, 4738, 4739, 4745, 4757, 4759, 4763, 4769, 4775, 4784, 4790, 4802,
				4811, 4812, 4817, 4828, 4832, 4834, 4851, 4856, 4857, 4858, 4860, 4872, 4880, 4889, 4903, 4913, 4915,
				4919, 4927, 4928, 4929, 4940, 4954, 4955, 4957, 4961, 4975, 5006, 5025, 5028, 5032, 5046, 5052, 5087,
				5087, 5093, 5098, 5103, 5121, 5157, 5160, 5167, 5181, 5207, 5214, 5229, 5238, 5247, 5249, 5252, 5253,
				5262, 5264, 5274, 5288, 5289, 5305, 5307, 5324, 5326, 5332, 5335, 5354, 5373, 5394, 5394, 5411, 5433,
				5464, 5465, 5503, 5519, 5533, 5535, 5550, 5555, 5562, 5562, 5584, 5616, 5630, 5633, 5646, 5646, 5647,
				5648, 5650, 5651, 5682, 5690, 5694, 5703, 5704, 5737, 5759, 5783, 5787, 5798, 5825, 5848, 5857, 5857,
				5861, 5874, 5890, 5902, 5907, 5907, 5928, 5928, 5950, 5956, 5972, 5986, 5988, 5989, 5996, 5998, 6021,
				6022, 6056, 6069, 6079, 6086, 6102, 6112, 6118, 6128, 6179, 6188, 6192, 6192, 6206, 6226, 6252, 6264,
				6269, 6285, 6290, 6304, 6306, 6311, 6311, 6314, 6315, 6320, 6336, 6338, 6368, 6375, 6375, 6402, 6409,
				6413, 6418, 6421, 6421, 6423, 6424, 6432, 6449, 6450, 6453, 6457, 6459, 6460, 6468, 6484, 6486, 6510,
				6512, 6520, 6522, 6522, 6546, 6559, 6584, 6585, 6587, 6588, 6591, 6592, 6616, 6626, 6627, 6632, 6637,
				6646, 6652, 6654, 6665, 6667, 6670, 6687, 6711, 6728, 6730, 6733, 6745, 6747, 6752, 6794, 6804, 6806,
				6810, 6815, 6842, 6843, 6855, 6897, 6899, 6899, 6911, 6912, 6926, 6942, 6982, 6986, 7002, 7007, 7014,
				7014, 7034, 7045, 7050, 7058, 7061, 7062, 7064, 7087, 7099, 7107, 7110, 7125, 7140, 7140, 7141, 7148,
				7154, 7157, 7158, 7169, 7184, 7204, 7212, 7235, 7235, 7238, 7240, 7250, 7253, 7267, 7282, 7286, 7301,
				7303, 7311, 7324, 7324, 7327, 7360, 7392, 7403, 7407, 7407, 7419, 7431, 7439, 7442, 7444, 7455, 7455,
				7456, 7458, 7459, 7476, 7482, 7484, 7512, 7514, 7540, 7541, 7555, 7557, 7563, 7570, 7571, 7571, 7579,
				7588, 7596, 7606, 7621, 7625, 7637, 7648, 7657, 7658, 7665, 7686, 7686, 7688, 7697, 7699, 7703, 7724,
				7731, 7751, 7780, 7780, 7784, 7791, 7809, 7812, 7820, 7824, 7851, 7891, 7919, 7934, 7938, 7940, 7942,
				7947, 7949, 7961, 7984, 8003, 8008, 8015, 8022, 8028, 8054, 8069, 8087, 8135, 8141, 8147, 8162, 8163,
				8199, 8199, 8211, 8234, 8241, 8280, 8289, 8294, 8295, 8298, 8298, 8301, 8308, 8314, 8343, 8349, 8355,
				8359, 8377, 8390, 8429, 8449, 8466, 8478, 8483, 8509, 8509, 8518, 8519, 8539, 8541, 8554, 8566, 8592,
				8593, 8608, 8642, 8668, 8669, 8671, 8674, 8688, 8690, 8697, 8701, 8705, 8712, 8712, 8725, 8729, 8740,
				8765, 8779, 8780, 8787, 8793, 8825, 8855, 8858, 8861, 8874, 8874, 8877, 8882, 8899, 8917, 8921, 8939,
				8957, 8965, 8967, 8980, 8986, 9026, 9045, 9062, 9088, 9090, 9125, 9133, 9133, 9142, 9147, 9148, 9160,
				9161, 9185, 9186, 9199, 9203, 9204, 9217, 9220, 9226, 9238, 9246, 9250, 9251, 9266, 9274, 9279, 9301,
				9305, 9313, 9324, 9327, 9344, 9345, 9356, 9357, 9359, 9371, 9372, 9397, 9435, 9442, 9456, 9457, 9459,
				9462, 9464, 9468, 9470, 9473, 9492, 9494, 9516, 9535, 9536, 9539, 9554, 9565, 9565, 9569, 9597, 9608,
				9609, 9613, 9621, 9623, 9660, 9667, 9694, 9702, 9717, 9722, 9725, 9733, 9737, 9751, 9753, 9754, 9754,
				9760, 9782, 9785, 9789, 9795, 9810, 9848, 9861, 9862, 9863, 9863, 9870, 9875, 9875, 9901, 9901, 9928,
				9940, 9959, 9979, 9982, 9987, 9989, 9998, 10013, 10025, 10041, 10057, 10058, 10059, 10105, 10105, 10119,
				10132, 10143, 10149, 10169, 10185, 10194, 10194, 10195, 10225, 10257, 10261, 10264, 10300, 10302, 10303,
				10304, 10319, 10324, 10334, 10339, 10341, 10367, 10383, 10391, 10393, 10395, 10400, 10403 };

		System.out.println(new SubsequenceRemoval().findSubsequence(a).toString());
		System.out.println(new SubsequenceRemoval().findSubsequence2(a).toString());
	}

	public static List<Integer> findSubsequence(int arr[]) {

		HashSet set = new HashSet<Integer>();
		LinkedList list = new LinkedList<Integer>();
		LinkedList emptyLinkedList = new LinkedList<Integer>();
		emptyLinkedList.add(-1);

		Integer maxInteger = 0;

		for (Integer i : arr) {
			if (set.contains(i)) {
				if (maxInteger <= i) {
					maxInteger = i;
					list.add(i);
				} else {
					return emptyLinkedList;
				}
			} else {
				set.add(i);
			}
		}
		return list;
	}

	public static List<Integer> findSubsequence2(int[] arr) {
		List<Integer> tr = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			tr.add(arr[i]);
			
		}
		// Write your code here
		Set<Integer> set = new HashSet<>();
		List<Integer> res = new ArrayList<>();
		int prevMax = 0;

		List<Integer> temp = new ArrayList<>();
		temp.add(-1);

		for (Integer item : tr) {
			if (set.contains(item)) {
				if (prevMax <= item) {
					prevMax = item;
					res.add(item);
				} else {
					System.out.println(" array is: " + arr.toString());
					return temp;
				}
			} else {
				set.add(item);
			}
		}

		return res;

	}
}
