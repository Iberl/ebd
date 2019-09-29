package ebd.messageLibrary.util;

import ebd.messageLibrary.serialization.annotations.Signed;

public class ETCSVariables {

	// Identifier if no Value is available
	public static final int INTEGER_NOVALUE     = -1;
	public static final long LONG_NOVALUE 		= -1;
	public static final boolean BOOLEAN_NOVALUE = false;

	// If Min and/or Max is Set = Numbers
	// All Other Values = Spare


	// ------------
	// Acceleration
	// ------------

	/**
	 * Name: A_NVMAXREDADH1 <br>
	 * Description: Maximum Deceleration Under Reduced Adhesion Conditions (1) <br>
	 * Length: 6 <br>
	 * Min: 0 <br>
	 * Max: 3.15 m/s^2 <br>
	 * Resolution: 0.05 m/s^2
	 */
	public static final int A_NVMAXREDADH1 = INTEGER_NOVALUE;

	/**
	 * Name: A_NVMAXREDADH2 <br>
	 * Description: Maximum Deceleration Under Reduced Adhesion Conditions (2) <br>
	 * Length: 6 <br>
	 * Min: 0 <br>
	 * Max: 3.15 m/s^2 <br>
	 * Resolution: 0.05 m/s^2
	 */
	public static final int A_NVMAXREDADH2 = INTEGER_NOVALUE;

	/**
	 * Name: A_NVMAXREDADH3 <br>
	 * Description: Maximum Deceleration Under Reduced Adhesion Conditions (3) <br>
	 * Length: 6 <br>
	 * Min: 0 <br>
	 * Max: 3.15 m/s^2 <br>
	 * Resolution: 0.05 m/s^2
	 */
	public static final int A_NVMAXREDADH3 = INTEGER_NOVALUE;

	/**
	 * Name: A_NVP12 <br>
	 * Description: Lower Deceleration Limit To Determine The Set Of Kv To Be Used <br>
	 * Length: 6 <br>
	 * Min: 0 <br>
	 * Max: 3.15 m/s^2 <br>
	 * Resolution: 0.05 m/s^2
	 */
	public static final int A_NVP12 = INTEGER_NOVALUE;

	/**
	 * Name: A_NVP23 <br>
	 * Description: Upper Deceleration Limit To Determine The Set Of Kv To Be Used <br>
	 * Length: 6 <br>
	 * Min: 0 <br>
	 * Max: 3.15 m/s^2 <br>
	 * Resolution: 0.05 m/s^2
	 */
	public static final int A_NVP23 = INTEGER_NOVALUE;



	// --------
	// Distance
	// --------

	/**
	 * Name: D_ADHESION <br>
	 * Description: Distance To Start Of Area With Reduced Adhesion Factor <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_ADHESION = INTEGER_NOVALUE;

	/**
	 * Name: D_AXLELOAD <br>
	 * Description: Incremental Distance To Start Of Next Axleload Speed Profile <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_AXLELOAD = INTEGER_NOVALUE;

	/**
	 * Name: D_CURRENT <br>
	 * Description: Distance To Change Of Allowed Current Consumption <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_CURRENT = INTEGER_NOVALUE;

	/**
	 * Name: D_CYCLOC <br>
	 * Description: Distance Between Two Position Reports From Train <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_CYCLOC                  = INTEGER_NOVALUE;
	public static final int D_CYCLOC_NO_CYCLIC_REPORT = 32767;

	/**
	 * Name: D_DP <br>
	 * Description: Distance From End Of Authority To Danger Point <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_DP = INTEGER_NOVALUE;

	/**
	 * Name: D_EMERGENCYSTOP <br>
	 * Description: Distance To Emergency Stop Location <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_EMERGENCYSTOP = INTEGER_NOVALUE;

	/**
	 * Name: D_ENDTIMERSTARTLOC <br>
	 * Description: Distance To End Section Timer Start Location To End Of Authority <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_ENDTIMERSTARTLOC = INTEGER_NOVALUE;

	/**
	 * Name: D_GRADIENT <br>
	 * Description: Incremental Distance To Next Change Of Gradient <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_GRADIENT = INTEGER_NOVALUE;

	/**
	 * Name: D_INFILL <br>
	 * Description: Distance To Location Where To (Dis)Connect To A Radio Infill Unit <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_INFILL = INTEGER_NOVALUE;

	/**
	 * Name: D_LEVELTR <br>
	 * Description: Distance To Level Transition <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_LEVELTR     = INTEGER_NOVALUE;
	public static final int D_LEVELTR_NOW = 32767;

	/**
	 * Name: D_LOC <br>
	 * Description: Incremental Linking Distance To Next Linked Balise Group<br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_LINK = INTEGER_NOVALUE;

	/**
	 * Name: D_LOC <br>
	 * Description: Incremental Distance Between Loacations Where Train Has To Report Position <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_LOC = INTEGER_NOVALUE;

	/**
	 * Name: D_LOOP <br>
	 * Description: Distance Between EOLM Ans Start Of Loop <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_LOOP		   = INTEGER_NOVALUE;
	public static final int D_LOOP_UNKNOWN = 32767;

	/**
	 * Name: D_LRBG <br>
	 * Description: Distance Between LRBG And Estimated Front End Of Train <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_LRBG         = INTEGER_NOVALUE;
	public static final int D_LRBG_UNKNOWN = 32767;

	/**
	 * Name: D_LX <br>
	 * Description: Distance To LX Start Location <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_LX = INTEGER_NOVALUE;

	/**
	 * Name: D_MAMODE <br>
	 * Description: Incremental Distance To Start Of Next Mode Profile <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_MAMODE = INTEGER_NOVALUE;

	/**
	 * Name: D_NVOVTRP <br>
	 * Description: Maximum Distance For Overriding The Train Trip <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_NVOVTRP = INTEGER_NOVALUE;

	/**
	 * Name: D_NVPOTRP <br>
	 * Description: Maximum Distance For Reversing In Post Trip Mode <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_NVPOTRP = INTEGER_NOVALUE;

	/**
	 * Name: D_NVROLL <br>
	 * Description: Roll Away Distance Limit <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_NVROLL          = INTEGER_NOVALUE;
	public static final int D_NVROLL_INFINITY = 32767;

	/**
	 * Name: D_NVSTFF <br>
	 * Description: Maximum Distance For Running In Staff Responsible Mode <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_NVSTFF          = INTEGER_NOVALUE;
	public static final int D_NVSTFF_INFINITY = 32767;

	/**
	 * Name: D_OL <br>
	 * Description: Distance From End Of Authority To End Of Overlap <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_OL = INTEGER_NOVALUE;

	/**
	 * Name: D_PBD <br>
	 * Description: Permitted Breaking Distance <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_PBD = INTEGER_NOVALUE;

	/**
	 * Name: D_REF <br>
	 * Description: Incremental Distance To Start Of Next Speed Restriction To Ensure PBD <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_PBDSR = INTEGER_NOVALUE;

	/**
	 * Name: D_POSOFF <br>
	 * Description: Offset From Location Reference Of Geographical Position Balise Group To The Related Track km Reference <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_POSOFF = INTEGER_NOVALUE;

	/**
	 * Name: D_RBCTR <br>
	 * Description: Distance To RBC Transition <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_RBCTR = INTEGER_NOVALUE;

	/**
	 * Name: D_PBDSR <br>
	 * Description: Reference distance <br>
	 * Length: 16 <br>
	 * Min: -327.680 km <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE <br>
	 * Note: NOVALUE = 0
	 */
	@Signed
	public static final int D_REF = 0;

	/**
	 * Name: D_REVERSE <br>
	 * Description: Maximum Distance To Run In RV Mode <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_REVERSE          = INTEGER_NOVALUE;
	public static final int D_REVERSE_INFINITY = 32767;

	/**
	 * Name: D_SECTIONTIMERSTOPLOC <br>
	 * Description: Distance From Beginning Of Section To Section Timeout Stop Location <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_SECTIONTIMERSTOPLOC = INTEGER_NOVALUE;

	/**
	 * Name: D_SR <br>
	 * Description: Distance In SR Mode <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_SR = INTEGER_NOVALUE;
	public static final int D_SR_INFINITY = 32767;

	/**
	 * Name: D_STARTOL <br>
	 * Description: Distance From Overlap Timer Start Location To End Of Authority <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_STARTOL = INTEGER_NOVALUE;

	/**
	 * Name: D_STARTREVERSE <br>
	 * Description: Distance To Start Of Reversing Permitted Area <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_STARTREVERSE = INTEGER_NOVALUE;

	/**
	 * Name: D_STATIC <br>
	 * Description: Incremental Distance To Next Discontinuity In Internal SSP Profile <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_STATIC = INTEGER_NOVALUE;

	/**
	 * Name: D_SUITABILITY <br>
	 * Description: Distance To Change In Route Suitability <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_SUITABILITY = INTEGER_NOVALUE;

	/**
	 * Name: D_TAFDISPLAY <br>
	 * Description: Distance From Where On A Track Ahead Free Request Shall Be Displayed <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_TAFDISPLAY = INTEGER_NOVALUE;

	/**
	 * Name: D_TEXTDISPLAY <br>
	 * Description: Distance From Where On A Text Shall Be Displayed <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_TEXTDISPLAY 					   = INTEGER_NOVALUE;
	public static final int D_TEXTDISPLAY_NOT_DISTANCE_LIMITED = 32767;

	/**
	 * Name: D_TRACKCOND <br>
	 * Description: Incremental Distance To Track Condition Change <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_TRACKCOND = INTEGER_NOVALUE;

	/**
	 * Name: D_TRACKINIT <br>
	 * Description: Distance To Start Of Empty Profile <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_TRACKINIT = INTEGER_NOVALUE;

	/**
	 * Name: D_TRACTION <br>
	 * Description: Distance To Change Of Traction <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_TRACTION = INTEGER_NOVALUE;

	/**
	 * Name: D_TSR <br>
	 * Description: Distance To Beginning Of Temporary Speed Restriction <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_TSR = INTEGER_NOVALUE;

	/**
	 * Name: D_VALIDNV <br>
	 * Description: Distance To Start Of Validity Of National Values <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int D_VALIDNV     = INTEGER_NOVALUE;
	public static final int D_VALIDNV_NOW = 32767;



	// --------
	// Gradient
	// --------

	/**
	 * Name: G_A <br>
	 * Description: Safe Gradient / Absolute Value Of Minimum Gradient Between Two Defined Locations <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 254 <br>
	 * Resolution: 1
	 */
	public static final int G_A                 = INTEGER_NOVALUE;
	public static final int G_A_END_DESCRIPTION = 255;

	/**
	 * Name: G_PBDSR <br>
	 * Description: Default Gradient For PBD Speed Restriction <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 255 <br>
	 * Resolution: 1
	 */
	public static final int G_PBDSR = INTEGER_NOVALUE;

	/**
	 * Name: G_TSR <br>
	 * Description: Default Gradient For TSR Supervision <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 255 <br>
	 * Resolution: 1
	 */
	public static final int G_TSR = INTEGER_NOVALUE;



	// ------
	// Length
	// ------

	/**
	 * Name: L_ACKLEVELTR <br>
	 * Description: Length Of Acknowledgement Area In Rear Of Required Level <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_ACKLEVELTR = INTEGER_NOVALUE;

	/**
	 * Name: L_ACKMAMODE <br>
	 * Description: Length Of Acknowledgement Area In Rear Of Start Of Required Mode <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_ACKMAMODE = INTEGER_NOVALUE;

	/**
	 * Name: L_ADHESION <br>
	 * Description: Length Of Reduced Adhesion <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_ADHESION = INTEGER_NOVALUE;

	/**
	 * Name: L_AXLELOAD <br>
	 * Description: Length Of Reduced Adhesion <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_AXLELOAD = INTEGER_NOVALUE;

	/**
	 * Name: L_DOUBTOVER <br>
	 * Description: Over-Reading Amount Plus Q_LOCACC Of LRBG <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_DOUBTOVER = INTEGER_NOVALUE;

	/**
	 * Name: L_DOUBTUNDER <br>
	 * Description: Under-Reading Amount Plus Q_LOCACC Of LRBG <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_DOUBTUNDER = INTEGER_NOVALUE;

	/**
	 * Name: L_ENDSECTION <br>
	 * Description: Length Of End Section In MA <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_ENDSECTION = INTEGER_NOVALUE;

	/**
	 * Name: L_LOOP <br>
	 * Description: Length Of Loop<br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_LOOP		   = INTEGER_NOVALUE;
	public static final int L_LOOP_UNKNOWN = 32767;

	/**
	 * Name: L_LX <br>
	 * Description: Length Of LX Area <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_LX = INTEGER_NOVALUE;

	/**
	 * Name: L_MAMODE <br>
	 * Description: Length Of Area Of Required Mode <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.660 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_MAMODE          = INTEGER_NOVALUE;
	public static final int L_MAMODE_INFINITY = 32767;

	/**
	 * Name: L_MESSAGE <br>
	 * Description: Message Length <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1023 <br>
	 * Resolution: 1 Byte
	 */
	public static final int L_MESSAGE = INTEGER_NOVALUE;

	/**
	 * Name: L_NVKRINT <br>
	 * Description: Train Length Step Used To Define The Integrated Correction Factor Kr <br>
	 * Length: 5
	 */
	public static final int L_NVKRINT       = INTEGER_NOVALUE;
	public static final int L_NVKRINT_0M    = 0;
	public static final int L_NVKRINT_25M   = 1;
	public static final int L_NVKRINT_50M   = 2;
	public static final int L_NVKRINT_75M   = 3;
	public static final int L_NVKRINT_100M  = 4;
	public static final int L_NVKRINT_150M  = 5;
	public static final int L_NVKRINT_200M  = 6;
	public static final int L_NVKRINT_300M  = 7;
	public static final int L_NVKRINT_400M  = 8;
	public static final int L_NVKRINT_500M  = 9;
	public static final int L_NVKRINT_600M  = 10;
	public static final int L_NVKRINT_700M  = 11;
	public static final int L_NVKRINT_800M  = 12;
	public static final int L_NVKRINT_900M  = 13;
	public static final int L_NVKRINT_1000M = 14;
	public static final int L_NVKRINT_1100M = 15;
	public static final int L_NVKRINT_1200M = 16;
	public static final int L_NVKRINT_1300M = 17;
	public static final int L_NVKRINT_1400M = 18;
	public static final int L_NVKRINT_1500M = 19;
	public static final int L_NVKRINT_1600M = 20;
	public static final int L_NVKRINT_1700M = 21;
	public static final int L_NVKRINT_1800M = 22;
	public static final int L_NVKRINT_1900M = 23;
	public static final int L_NVKRINT_2000M = 24;
	public static final int L_NVKRINT_2100M = 25;
	public static final int L_NVKRINT_2200M = 26;
	public static final int L_NVKRINT_2300M = 27;
	public static final int L_NVKRINT_2400M = 28;
	public static final int L_NVKRINT_2500M = 29;
	public static final int L_NVKRINT_2600M = 30;
	public static final int L_NVKRINT_2700M = 31;



	/**
	 * Name: L_PACKET <br>
	 * Description: Packet Length <br>
	 * Length: 13 <br>
	 * Min: 0 <br>
	 * Max: 8191 <br>
	 * Resolution: 1 bit
	 */
	public static final int L_PACKET = INTEGER_NOVALUE;

	/**
	 * Name: L_PBDSR <br>
	 * Description: Length Of Speed Restriction To Ensure PBD <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_PBDSR = INTEGER_NOVALUE;

	/**
	 * Name: L_REVERSEAREA <br>
	 * Description: Length Of Reversing Permitted Area <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_REVERSEAREA = INTEGER_NOVALUE;

	/**
	 * Name: L_SECTION <br>
	 * Description: Length Of Section In MA <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_SECTION = INTEGER_NOVALUE;

	/**
	 * Name: L_STOPLX <br>
	 * Description: Length Of Stopping Area In Rear Of Start Location Of LX Area <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_STOPLX = INTEGER_NOVALUE;

	/**
	 * Name: L_TAFDISPLAY <br>
	 * Description: Length On Which A Track Ahead Free Request Shall Be Displayed <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_TAFDISPLAY = INTEGER_NOVALUE;

	/**
	 * Name: L_TEXT <br>
	 * Description: Length Of Text String <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_TEXT = INTEGER_NOVALUE;

	/**
	 * Name: L_TEXTDISPLAY <br>
	 * Description: Length On Which A Text Shall Be Displayed <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_TEXTDISPLAY = INTEGER_NOVALUE;

	/**
	 * Name: L_TRACKCOND <br>
	 * Description: Length For Which Defined Track Condition Is Valid <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 327.670 km <br>
	 * Resolution: Depends on Q_SCALE
	 */
	public static final int L_TRACKCOND = INTEGER_NOVALUE;

	/**
	 * Name: L_TRAIN <br>
	 * Description: Train Length <br>
	 * Length: 12 <br>
	 * Min: 0 <br>
	 * Max: 4095 m <br>
	 * Resolution: 1 m
	 */
	public static final int L_TRAIN = INTEGER_NOVALUE;

	/**
	 * Name: L_TRAININIT <br>
	 * Description: Safe Train Length <br>
	 * Length: 15 <br>
	 * Min: 0 <br>
	 * Max: 32767 m <br>
	 * Resolution: 1 m
	 */
	public static final int L_TRAININIT = INTEGER_NOVALUE;

	/**
	 * Name: L_TSR <br>
	 * Description: Length Of Tempory Speed Restriction <br>
	 * Length: 12 <br>
	 * Min: 0 <br>
	 * Max: 4095 m <br>
	 * Resolution: 1 m
	 */
	public static final int L_TSR = INTEGER_NOVALUE;



	// -------------
	// Miscellaneous
	// -------------

	/**
	 * Name: M_ACK <br>
	 * Description: Indicates Whether The Telegram Must Be Acknowledged Or Not <br>
	 * Length: 1
	 */
	public static final boolean M_ACK              = BOOLEAN_NOVALUE;
	public static final boolean M_ACK_NOT_REQUIRED = false;
	public static final boolean M_ACK_REQUIRED     = true;

	/**
	 * Name: M_ADHESION <br>
	 * Description: Adhesion Factor <br>
	 * Length: 1
	 */
	public static final boolean M_ADHESION                   = BOOLEAN_NOVALUE;
	public static final boolean M_ADHESION_SLIPPERY_RAIL     = false;
	public static final boolean M_ADHESION_NON_SLIPPERY_RAIL = true;

	/**
	 * Name: M_AIRTIGHT <br>
	 * Description: Airtight System Presence <br>
	 * Length: 2
	 */
	public static final int M_AIRTIGHT            = INTEGER_NOVALUE;
	public static final int M_AIRTIGHT_NOT_FITTED = 0;
	public static final int M_AIRTIGHT_FITTED     = 1;

	/**
	 * Name: M_AXLELOADCAT <br>
	 * Description: Axle Load Category <br>
	 * Length: 7
	 */
	public static final int M_AXLELOADCAT      = INTEGER_NOVALUE;
	public static final int M_AXLELOADCAT_A    = 0;
	public static final int M_AXLELOADCAT_HS17 = 1;
	public static final int M_AXLELOADCAT_B1   = 2;
	public static final int M_AXLELOADCAT_B2   = 3;
	public static final int M_AXLELOADCAT_C2   = 4;
	public static final int M_AXLELOADCAT_C3   = 5;
	public static final int M_AXLELOADCAT_C4   = 6;
	public static final int M_AXLELOADCAT_D2   = 7;
	public static final int M_AXLELOADCAT_D3   = 8;
	public static final int M_AXLELOADCAT_D4   = 9;
	public static final int M_AXLELOADCAT_D4XL = 10;
	public static final int M_AXLELOADCAT_E4   = 11;
	public static final int M_AXLELOADCAT_E5   = 12;

	/**
	 * Name: M_CURRENT <br>
	 * Description: Allowed Current Consumption <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 10000 A <br>
	 * Resolution: 10 A
	 */
	public static final int M_CURRENT                = INTEGER_NOVALUE;
	public static final int M_CURRENT_NO_RESTRICTION = 1023;

	/**
	 * Name: M_DUP <br>
	 * Description: Tells Whether The Balise Is A Duplicate Of One Of The Adjacent Balises
	 * Length: 2
	 */
	public static final int M_DUP              = INTEGER_NOVALUE;
	public static final int M_DUP_NO_DUPLICATE = 0;
	public static final int M_DUP_NEXT_BALISE  = 1;
	public static final int M_DUP_PREV_BALISE  = 2;

	/**
	 * Name: M_ERROR <br>
	 * Description: Identifier Of The Type Of Error <br>
	 * Length: 8
	 */
	public static final int M_ERROR                         = INTEGER_NOVALUE;
	public static final int M_ERROR_BALISE_GROUP            = 0;
	public static final int M_ERROR_LINKED_BALISE_GROUP     = 1;
	public static final int M_ERROR_UNLINKED_BALISE_GROUP   = 2;
	public static final int M_ERROR_MESSAGE_CONSISTENCY     = 3;
	public static final int M_ERROR_SEQUENCE                = 4;
	public static final int M_ERROR_SAFE_CONNECTION         = 5;
	public static final int M_ERROR_SAFETY_CRITICAL_FAILURE = 6;
	public static final int M_ERROR_DOUBLE_LINKING          = 7;
	public static final int M_ERROR_DOUBLE_RESPONDING       = 8;

	/**
	 * Name: M_LEVEL <br>
	 * Description: Current Operating Level <br>
	 * Length: 3
	 */
	public static final int M_LEVEL     = INTEGER_NOVALUE;
	public static final int M_LEVEL_0   = 0;
	public static final int M_LEVEL_NTC = 1;
	public static final int M_LEVEL_1   = 2;
	public static final int M_LEVEL_2   = 3;
	public static final int M_LEVEL_3   = 4;

	/**
	 * Name: M_LEVELTEXTDISPLAY <br>
	 * Description: Onboard Operating Level For Text Display <br>
	 * Length: 3
	 */
	public static final int M_LEVELTEXTDISPLAY     = INTEGER_NOVALUE;
	public static final int M_LEVELTEXTDISPLAY_0   = 0;
	public static final int M_LEVELTEXTDISPLAY_NTC = 1;
	public static final int M_LEVELTEXTDISPLAY_1   = 2;
	public static final int M_LEVELTEXTDISPLAY_2   = 3;
	public static final int M_LEVELTEXTDISPLAY_3   = 4;

	/**
	 * Name: M_LEVELTR <br>
	 * Description: Required Level <br>
	 * Length: 3
	 */
	public static final int M_LEVELTR     = INTEGER_NOVALUE;
	public static final int M_LEVELTR_0   = 0;
	public static final int M_LEVELTR_NTC = 1;
	public static final int M_LEVELTR_1   = 2;
	public static final int M_LEVELTR_2   = 3;
	public static final int M_LEVELTR_3   = 4;


	/**
	 * Name: M_LINEGAUGE <br>
	 * Description: Permitted Loading Gauges On A Line <br>
	 * Length: 8 <br>
	 * Resolution: Bitset
	 */
	public static final int M_LINEGAUGE    = INTEGER_NOVALUE;
	public static final int M_LINEGAUGE_G1 = 1;
	public static final int M_LINEGAUGE_GA = 2;
	public static final int M_LINEGAUGE_GB = 4;
	public static final int M_LINEGAUGE_GC = 8;

	/**
	 * Name: M_LOADINGGAUGE <br>
	 * Description: Loading Gauge Profile Of A Train <br>
	 * Length: 8
	 */
	public static final int M_LOADINGGAUGE            = INTEGER_NOVALUE;
	public static final int M_LOADINGGAUGE_NO_PROFILE = 0;
	public static final int M_LOADINGGAUGE_G1         = 1;
	public static final int M_LOADINGGAUGE_GA         = 2;
	public static final int M_LOADINGGAUGE_GB         = 3;
	public static final int M_LOADINGGAUGE_GC         = 4;

	/**
	 * Name: M_LOC <br>
	 * Description: Special Location Where Train Has To Report Its Position <br>
	 * Length: 3
	 */
	public static final int M_LOC                     = INTEGER_NOVALUE;
	public static final int M_LOC_NOW                 = 0;
	public static final int M_LOC_AT_BALISE_GROUP     = 1;
	public static final int M_LOC_NOT_AT_BALISE_GROUP = 2;

	/**
	 * Name: M_MAMODE <br>
	 * Description: Required Mode For A Part Of MA <br>
	 * Length: 2
	 */
	public static final int M_MAMODE                     = INTEGER_NOVALUE;
	public static final int M_MAMODE_ON_SIGHT            = 0;
	public static final int M_MAMODE_SHUNTING            = 1;
	public static final int M_MAMODE_LIMITED_SUPERVISION = 2;

	/**
	 * Name: M_MCOUNT <br>
	 * Description: Message Counter <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 253
	 */
	public static final int M_MCOUNT      = INTEGER_NOVALUE;
	public static final int M_MCOUNT_NONE = 254;
	public static final int M_MCOUNT_ALL  = 255;

	/**
	 * Name: M_MODE <br>
	 * Description: Onboard Operating Mode <br>
	 * Length: 4
	 */
	public static final int M_MODE                     = INTEGER_NOVALUE;
	public static final int M_MODE_FULL_SUPERVISION    = 0;
	public static final int M_MODE_ON_SIGHT            = 1;
	public static final int M_MODE_STAFF_RESPONSIBLE   = 2;
	public static final int M_MODE_SHUNTING            = 3;
	public static final int M_MODE_UNFITTED            = 4;
	public static final int M_MODE_SLEEPING            = 5;
	public static final int M_MODE_STAND_BY            = 6;
	public static final int M_MODE_TRIP                = 7;
	public static final int M_MODE_POST_TRIP           = 8;
	public static final int M_MODE_SYSTEM_FAILURE      = 9;
	public static final int M_MODE_ISOLATION           = 10;
	public static final int M_MODE_NON_LEADING         = 11;
	public static final int M_MODE_LIMITED_SUPERVISION = 12;
	public static final int M_MODE_NATIONAL_SYSTEM     = 13;
	public static final int M_MODE_REVERSING           = 14;
	public static final int M_MODE_PASSIVE_SHUNTING    = 15;

	/**
	 * Name: M_MODETEXTDISPLAY <br>
	 * Description: Onboard Operating Mode For Text Display <br>
	 * Length: 4
	 */
	public static final int M_MODETEXTDISPLAY                     = INTEGER_NOVALUE;
	public static final int M_MODETEXTDISPLAY_FULL_SUPERVISION    = 0;
	public static final int M_MODETEXTDISPLAY_ON_SIGHT            = 1;
	public static final int M_MODETEXTDISPLAY_STAFF_RESPONSIBLE   = 2;
	public static final int M_MODETEXTDISPLAY_SHUNTING            = 3;
	public static final int M_MODETEXTDISPLAY_UNFITTED            = 4;
	public static final int M_MODETEXTDISPLAY_SLEEPING            = 5;
	public static final int M_MODETEXTDISPLAY_STAND_BY            = 6;
	public static final int M_MODETEXTDISPLAY_TRIP                = 7;
	public static final int M_MODETEXTDISPLAY_POST_TRIP           = 8;
	public static final int M_MODETEXTDISPLAY_SYSTEM_FAILURE      = 9;
	public static final int M_MODETEXTDISPLAY_ISOLATION           = 10;
	public static final int M_MODETEXTDISPLAY_NON_LEADING         = 11;
	public static final int M_MODETEXTDISPLAY_LIMITED_SUPERVISION = 12;
	public static final int M_MODETEXTDISPLAY_NATIONAL_SYSTEM     = 13;
	public static final int M_MODETEXTDISPLAY_REVERSING           = 14;
	public static final int M_MODETEXTDISPLAY_NOT_MODE_LIMITED    = 15;

	/**
	 * Name: M_NVAVADH <br>
	 * Description: Weighting Factor For Available Wheel/Rail Adhesion <br>
	 * Length: 5 <br>
	 * Min: 0 <br>
	 * Max: 1.00 <br>
	 * Resolution: 0.05 <br>
	 * 1.05-1.55: Spare
	 */
	public static final int M_NVAVADH = INTEGER_NOVALUE;

	/**
	 * Name: M_NVCONTACT <br>
	 * Description: T_NVCONTACT Reaction <br>
	 * Length: 2
	 */
	public static final int M_NVCONTACT                     = INTEGER_NOVALUE;
	public static final int M_NVCONTACT_TAIN_TRIP           = 0;
	public static final int M_NVCONTACT_APPLY_SERVICE_BREAK = 1;
	public static final int M_NVCONTACT_NO_REACTION         = 2;
	public static final int M_NVCONTACT_SPARE               = 3;

	/**
	 * Name: M_NVDERUN <br>
	 * Description: Entry Of Driver ID Permitted While Running <br>
	 * Length: 1
	 */
	public static final boolean M_NVDERUN     = BOOLEAN_NOVALUE;
	public static final boolean M_NVDERUN_NO  = false;
	public static final boolean M_NVDERUN_YES = true;

	/**
	 * Name: M_NVEBCL <br>
	 * Description: Confidence Level For Emergency Brake Safe Deceleration On Dry Rails <br>
	 * Length: 4 <br>
	 * 10-15: Spare
	 */
	public static final int M_NVEBCL                             = INTEGER_NOVALUE;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_50         = 0;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_90         = 1;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_99         = 2;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_99_9       = 3;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_99_99      = 4;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_99_999     = 5;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_99_9999    = 6;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_99_99999   = 7;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_99_999999  = 8;
	public static final int M_NVEBCL_CONFIDENCE_LEVEL_99_9999999 = 9;

	/**
	 * Name: M_NVKRINT <br>
	 * Description: Integrated Correction Factor Kr <br>
	 * Length: 5 <br>
	 * Min: 0 <br>
	 * Max: 1.55 <br>
	 * Resolution: 0.05
	 */
	public static final int M_NVKRINT = INTEGER_NOVALUE;

	/**
	 * Name: M_NVKTINT <br>
	 * Description: Integrated Correction Factor Kt <br>
	 * Length: 5 <br>
	 * Min: 0 <br>
	 * Max: 1.55 <br>
	 * Resolution: 0.05
	 */
	public static final int M_NVKTINT = INTEGER_NOVALUE;

	/**
	 * Name: M_NVKVINT <br>
	 * Description: Integrated Correction Factor Kv <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 2.54 <br>
	 * Resolution: 0.02
	 */
	public static final int M_NVKVINT = INTEGER_NOVALUE;

	/**
	 * Name: M_PLATFORM <br>
	 * Description: Nominal Height Of Platform Above Rail Level <br>
	 * Length: 4
	 */
	public static final int M_PLATFORM         = INTEGER_NOVALUE;
	public static final int M_PLATFORM_200     = 0;
	public static final int M_PLATFORM_300_380 = 1;
	public static final int M_PLATFORM_550     = 2;
	public static final int M_PLATFORM_580     = 3;
	public static final int M_PLATFORM_680     = 4;
	public static final int M_PLATFORM_685     = 5;
	public static final int M_PLATFORM_730     = 6;
	public static final int M_PLATFORM_760     = 7;
	public static final int M_PLATFORM_840     = 8;
	public static final int M_PLATFORM_900     = 9;
	public static final int M_PLATFORM_915     = 10;
	public static final int M_PLATFORM_920     = 11;
	public static final int M_PLATFORM_960     = 12;
	public static final int M_PLATFORM_1100    = 13;

	/**
	 * Name: M_POSITION <br>
	 * Description: Track Kilometre Reference Value <br>
	 * Length: 24 <br>
	 * Min: 0 <br>
	 * Max: 9999999 m <br>
	 * Resolution: 1 m <br>
	 * 10000000 - 16777214: Spare
	 */
	public static final int M_POSITION 							 = INTEGER_NOVALUE;
	public static final int M_POSITION_NO_CALCULATION_AFTER_THIS = 16777215;

	/**
	 * Name: M_TRACKCOND <br>
	 * Description: Type Of Track Condition <br>
	 * Length: 4
	 */
	public static final int M_TRACKCOND                                  = INTEGER_NOVALUE;
	public static final int M_TRACKCOND_NON_STOPPING_AREA                = 0;
	public static final int M_TRACKCOND_TUNNEL_STOPPING_AREA             = 1;
	public static final int M_TRACKCOND_SOUND_HORN                       = 2;
	public static final int M_TRACKCOND_POWERLESS_SECTION                = 3;
	public static final int M_TRACKCOND_RADIO_HOLE                       = 4;
	public static final int M_TRACKCOND_AIR_TIGHTNESS                    = 5;
	public static final int M_TRACKCOND_REGENERATIVE_BRAKE_OFF           = 6;
	public static final int M_TRACKCOND_EDDY_BRAKE_OFF_FOR_SERVICE       = 7;
	public static final int M_TRACKCOND_MAGNETIC_SHOE_BRAKE_OFF          = 8;
	public static final int M_TRACKCOND_POWERLESS_SECTION_MAIN_POWER_OFF = 9;
	public static final int M_TRACKCOND_EDDY_BRAKE_OFF_FOR_EMERGENCY     = 10;

	/**
	 * Name: M_Version <br>
	 * Description: Version Of ETCS System <br>
	 * Length: 7
	 */
	public static final int M_VERSION     = INTEGER_NOVALUE;
	public static final int M_VERSION_1_0 = 16;
	public static final int M_VERSION_1_1 = 17;
	public static final int M_VERSION_2_0 = 32;

	/**
	 * Name: M_VOLTAGE <br>
	 * Description: Traction System Voltage <br>
	 * Length: 4
	 */
	public static final int M_VOLTAGE = INTEGER_NOVALUE;
	public static final int M_VOLTAGE_NO_TRACTION_SYSTEM = 0;
	public static final int M_VOLTAGE_AC_25kV_50Hz = 1;
	public static final int M_VOLTAGE_AC_15kV_16_7Hz = 2;
	public static final int M_VOLTAGE_DC_3kV = 3;
	public static final int M_VOLTAGE_DC_1_5kV = 4;
	public static final int M_VOLTAGE_DC_600V_750V = 5;



	// ------
	// Number
	// ------

	/**
	 * Name: N_AXLE <br>
	 * Description: Axle Number Of Engine <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1022 <br>
	 */
	public static final int N_AXLE         = INTEGER_NOVALUE;
	public static final int N_AXLE_UNKNOWN = 1023;

	/**
	 * Name: N_ITER <br>
	 * Description: Number Of Iterations Of Data Set Following This Variable In Packet
	 * Length: 5 <br>
	 * Min: 0 <br>
	 * Max: 31 <br>
	 */
	public static final int N_ITER = INTEGER_NOVALUE;

	/**
	 * Name: N_PIG <br>
	 * Description: Relative Position In A Balise Group <br>
	 * Length: 3
	 */
	public static final int N_PIG           = INTEGER_NOVALUE;
	public static final int N_PIG_POSITION_1 = 0;
	public static final int N_PIG_POSITION_2 = 1;
	public static final int N_PIG_POSITION_3 = 2;
	public static final int N_PIG_POSITION_4 = 3;
	public static final int N_PIG_POSITION_5 = 4;
	public static final int N_PIG_POSITION_6 = 5;
	public static final int N_PIG_POSITION_7 = 6;
	public static final int N_PIG_POSITION_8 = 7;

	/**
	 * Name: N_TOTAL <br>
	 * Description: Total Number Of Balise(s) In The Group <br>
	 * Length: 3
	 */
	public static final int N_TOTAL           = INTEGER_NOVALUE;
	public static final int N_TOTAL_1_BALISE  = 0;
	public static final int N_TOTAL_2_BALISES = 1;
	public static final int N_TOTAL_3_BALISES = 2;
	public static final int N_TOTAL_4_BALISES = 3;
	public static final int N_TOTAL_5_BALISES = 4;
	public static final int N_TOTAL_6_BALISES = 5;
	public static final int N_TOTAL_7_BALISES = 6;
	public static final int N_TOTAL_8_BALISES = 7;



	// ------------
	// Class Number
	// ------------

	/**
	 * Name: NC_CDDIFF <br>
	 * Description: Cant Deficiency SSP Category <br>
	 * Length: 4
	 */
	public static final int NC_CDDIFF     = INTEGER_NOVALUE;
	public static final int NC_CDDIFF_80  = 0;
	public static final int NC_CDDIFF_100 = 1;
	public static final int NC_CDDIFF_130 = 2;
	public static final int NC_CDDIFF_150 = 3;
	public static final int NC_CDDIFF_165 = 4;
	public static final int NC_CDDIFF_180 = 5;
	public static final int NC_CDDIFF_210 = 6;
	public static final int NC_CDDIFF_225 = 7;
	public static final int NC_CDDIFF_245 = 8;
	public static final int NC_CDDIFF_275 = 9;
	public static final int NC_CDDIFF_300 = 10;

	/**
	 * Name: NC_CDTRAIN <br>
	 * Description: Cant Deficiency Train Category <br>
	 * Length: 4
	 */
	public static final int NC_CDTRAIN     = INTEGER_NOVALUE;
	public static final int NC_CDTRAIN_80  = 0;
	public static final int NC_CDTRAIN_100 = 1;
	public static final int NC_CDTRAIN_130 = 2;
	public static final int NC_CDTRAIN_150 = 3;
	public static final int NC_CDTRAIN_165 = 4;
	public static final int NC_CDTRAIN_180 = 5;
	public static final int NC_CDTRAIN_210 = 6;
	public static final int NC_CDTRAIN_225 = 7;
	public static final int NC_CDTRAIN_245 = 8;
	public static final int NC_CDTRAIN_275 = 9;
	public static final int NC_CDTRAIN_300 = 10;

	/**
	 * Name: NC_DIFF <br>
	 * Description: Other Specific SSP Category <br>
	 * Length: 4
	 */
	public static final int NC_DIFF                 = INTEGER_NOVALUE;
	public static final int NC_DIFF_FREIGHT_PBRAKE  = 0;
	public static final int NC_DIFF_FREIGHT_GBRAKE  = 1;
	public static final int NC_DIFF_PASSENGER_TRAIN = 2;

	/**
	 * Name: NC_TRAIN <br>
	 * Description: Other International Train Category <br>
	 * Length: 15
	 */
	public static final int NC_TRAIN                 = INTEGER_NOVALUE;
	public static final int NC_TRAIN_NO_CATEGORY     = 0;
	public static final int NC_TRAIN_FREIGHT_PBRAKE  = 1;
	public static final int NC_TRAIN_FREIGHT_GBRAKE  = 2;
	public static final int NC_TRAIN_PASSENGER_TRAIN = 4;



	// ---------------
	// Identity Number
	// ---------------

	/**
	 * Name: NID_BG <br>
	 * Description: Identity Number Of Balise Group <br>
	 * Length: 14 <br>
	 * Min: 0 <br>
	 * Max: 16382
	 */
	public static final int NID_BG         = INTEGER_NOVALUE;
	public static final int NID_BG_UNKNOWN = 16383;

	/**
	 * Name: NID_C <br>
	 * Description: Identity Number Of Country Or Region <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1023
	 */
	public static final int NID_C = INTEGER_NOVALUE;

	/**
	 * Name: NID_CTRACTION <br>
	 * Description: Country Identifier Of Traction System <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1023
	 */
	public static final int NID_CTRACTION = INTEGER_NOVALUE;

	/**
	 * Name: NID_EM <br>
	 * Description: Identifies The Number Of The Emergency Message <br>
	 * Length: 4
	 */
	public static final int NID_EM = INTEGER_NOVALUE;

	/**
	 * Name: NID_ENGINE <br>
	 * Description: Onboard ETCS Identity <br>
	 * Length: 24
	 */
	public static final int NID_ENGINE = INTEGER_NOVALUE;

	/**
	 * Name: NID_ENGINE <br>
	 * Description: Identity Number Of Loop <br>
	 * Length: 14 <br>
	 * Min: 0 <br>
	 * Max: 16383
	 */
	public static final int NID_LOOP = INTEGER_NOVALUE;

	/**
	 * Name: NID_LRBG <br>
	 * Description: Identity Of Last Relevant Balise Group <br>
	 * Length: 10 + 14
	 */
	public static final int NID_LRBG         = INTEGER_NOVALUE;
	public static final int NID_LRBG_UNKNOWN = 16777215;

	/**
	 * Name: NID_LTRBG <br>
	 * Description: Identity Of Level 2/3 Transition Balise Group <br>
	 * Length: 10 + 14
	 */
	public static final int NID_LTRBG = INTEGER_NOVALUE;

	/**
	 * Name: NID_LX <br>
	 * Description: Identity Of Level Crossing <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 255 <br>
	 * 0-126: Reserved for non RBC Transmission (Balise, Loop or Radio Infill) <br>
	 * 127-255: Reserved for RBC Transmission
	 */
	public static final int NID_LX = INTEGER_NOVALUE;

	/**
	 * Name: NID_MESSAGE <br>
	 * Description: Message Identifier <br>
	 * Length: 8
	 */
	public static final int NID_MESSAGE = INTEGER_NOVALUE;

	/**
	 * Name: NID_MN <br>
	 * Description: Identity Of Radio Network <br>
	 * Length: 24 <br>
	 * Min: 0 <br>
	 * Max: 999999 <br>
	 * Resolution: Binary Coded Decimal <br>
	 * A-E (for each digit): Not Used <br>
	 * F (for each digit): Indicates No Digit
	 */
	public static final int NID_MN = INTEGER_NOVALUE;

	/**
	 * Name: NID_NTC <br>
	 * Description: National System Identity <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 255
	 */
	public static final int NID_NTC = INTEGER_NOVALUE;

	/**
	 * Name: NID_OPERATIONAL <br>
	 * Description: Train Running Number <br>
	 * Length: 24 <br>
	 * Min: 0 <br>
	 * Max: 999999 <br>
	 * Resolution: Binary Coded Decimal <br>
	 * A-E (for each digit): Spare <br>
	 * F (for each digit): Indicates No Digit <br>
	 * FFFF FFFF: Spare
	 */
	public static final int NID_OPERATIONAL = INTEGER_NOVALUE;

	/**
	 * Name: NID_PACKET <br>
	 * Description: Packet Identifier <br>
	 * Length: 8
	 */
	public static final int NID_PACKET = INTEGER_NOVALUE;

	/**
	 * Name: NID_PRVLRBG <br>
	 * Description: Identity Of Previous LRBG <br>
	 * Length: 10 + 14
	 */
	public static final int NID_PRVLRBG         = INTEGER_NOVALUE;
	public static final int NID_PRVLRBG_UNKNOWN = 16777215;

	/**
	 * Name: NID_RADIO <br>
	 * Description: Radio Subscriber Number <br>
	 * Length: 64 <br>
	 * Resolution: Binary Coded Decimal <br>
	 * A-E (for each digit): Not Used <br>
	 * F (for each digit): Indicates No Digit <br>
	 * FFFF FFFF FFFF FFFF: Use Short Number, Stored Onboard
	 */
	public static final long NID_RADIO			    = LONG_NOVALUE;
	public static final long NID_RADIO_SHORT_NUMBER = -1;

	/**
	 * Name: NID_RBC <br>
	 * Description: RBC ETCS identity number <br>
	 * Length: 14 <br>
	 * Min: 0 <br>
	 * Max: 16 382
	 */
	public static final int NID_RBC 		   = INTEGER_NOVALUE;
	public static final int NID_RBC_LAST_KNOWN = 16383;

	/**
	 * Name: NID_RIU <br>
	 * Description: Identity Of Radio Infill Unit <br>
	 * Length: 14 <br>
	 * Min: 0 <br>
	 * Max: 16383
	 */
	public static final int NID_RIU = INTEGER_NOVALUE;

	/**
	 * Name: NID_TEXTMESSAGE <br>
	 * Description: Text Message Identifier <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 255
	 */
	public static final int NID_TEXTMESSAGE = INTEGER_NOVALUE;

	/**
	 * Name: NID_TSR <br>
	 * Description: Identity Number Of Tempory Speed Restriction <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 255 <br>
	 * 0-126: Reserved for non RBC Transmission (Balise, Loop or Radio Infill) <br>
	 * 127-254: Reserved for RBC Transmission
	 */
	public static final int NID_TSR               = INTEGER_NOVALUE;
	public static final int NID_TSR_NON_REVOCABLE = 255;

	/**
	 * Name: NID_VBCMK <br>
	 * Description: Marker For Virtual Balise Cover <br>
	 * Length: 6 <br>
	 * Min: 0 <br>
	 * Max: 63
	 */
	public static final int NID_VBCMK = INTEGER_NOVALUE;

	/**
	 * Name: NID_XUSER <br>
	 * Description: Identity Of User System <br>
	 * Length: 9 <br>
	 * Min: 0 <br>
	 * Max: 511
	 */
	public static final int NID_XUSER = INTEGER_NOVALUE;



	// ---------
	// Qualifier
	// ---------

	/**
	 * Name: Q_ASPECT <br>
	 * Description: Aspect Of "Danger For Shunting" Signal <br>
	 * Length: 1
	 */
	public static final boolean Q_ASPECT               = BOOLEAN_NOVALUE;
	public static final boolean Q_ASPECT_STOP_IF_IN_SH = false;
	public static final boolean Q_ASPECT_GO_IF_IN_SH   = true;

	/**
	 * Name: Q_CONFTEXTDISPLAY <br>
	 * Description: Qualifier For Text Confirmation Versus End Of Text Display <br>
	 * Length: 1
	 */
	public static final boolean Q_CONFTEXTDISPLAY 				  = BOOLEAN_NOVALUE;
	public static final boolean Q_CONFTEXTDISPLAY_CONFIRMATION	  = false;
	public static final boolean Q_CONFTEXTDISPLAY_OTHER_CONDITION = true;

	/**
	 * Name: Q_DANGERPOINT <br>
	 * Description: Qualifier For Danger Point Description <br>
	 * Length: 1
	 */
	public static final boolean Q_DANGERPOINT         = BOOLEAN_NOVALUE;
	public static final boolean Q_DANGERPOINT_NO_INFO = false;
	public static final boolean Q_DANGERPOINT_INFO    = true;

	/**
	 * Name: Q_DIFF <br>
	 * Description: Type Of Specific SSP Category <br>
	 * Length: 2
	 */
	public static final int Q_DIFF                           = INTEGER_NOVALUE;
	public static final int Q_DIFF_CANT_DEFICIENCY           = 0;
	public static final int Q_DIFF_REPLACING_CANT_DEFICIENCY = 1;
	public static final int Q_DIFF_OTHER_SPECIFIC_CATEGORY   = 2;

	/**
	 * Name: Q_DIR <br>
	 * Description: Validity Direction Of Transmitted Data <br>
	 * Length: 2
	 */
	public static final int Q_DIR         = INTEGER_NOVALUE;
	public static final int Q_DIR_REVERSE = 0;
	public static final int Q_DIR_NOMINAL = 1;
	public static final int Q_DIR_BOTH    = 2;

	/**
	 * Name: Q_DIRLRBG <br>
	 * Description: Orientation Of Train In Relation To Direction Of LRBG <br>
	 * Length: 2
	 */
	public static final int Q_DIRLRBG         = INTEGER_NOVALUE;
	public static final int Q_DIRLRBG_REVERSE = 0;
	public static final int Q_DIRLRBG_NOMINAL = 1;
	public static final int Q_DIRLRBG_UNKNOWN = 2;

	/**
	 * Name: Q_DIRTRAIN <br>
	 * Description: Direction Of Train Movement In Relation To LRBG Orientation <br>
	 * Length: 2
	 */
	public static final int Q_DIRTRAIN         = INTEGER_NOVALUE;
	public static final int Q_DIRTRAIN_REVERSE = 0;
	public static final int Q_DIRTRAIN_NOMINAL = 1;
	public static final int Q_DIRTRAIN_UNKNOWN = 2;

	/**
	 * Name: Q_DLRBG <br>
	 * Description: Tells On Which Side Of LRBG The Estimated Front End Is <br>
	 * Length: 2
	 */
	public static final int Q_DLRBG         = INTEGER_NOVALUE;
	public static final int Q_DLRBG_REVERSE = 0;
	public static final int Q_DLRBG_NOMINAL = 1;
	public static final int Q_DLRBG_UNKNOWN = 2;

	/**
	 * Name: Q_EMERGENCYSTOP <br>
	 * Description: Qualifier For Emergency Stop Acknowledgement <br>
	 * Length: 2
	 */
	public static final int Q_EMERGENCYSTOP = INTEGER_NOVALUE;
	public static final int Q_EMERGENCYSTOP_ACCEPTED_EOA_UPDATE    = 0;
	public static final int Q_EMERGENCYSTOP_ACCEPTED_NO_EOA_UPDATE = 1;
	public static final int Q_EMERGENCYSTOP_NOT_RELEVANT           = 2;
	public static final int Q_EMERGENCYSTOP_REJECTED               = 3;

	/**
	 * Name: Q_ENDTIMER <br>
	 * Description: Indicates Whether End Section Timer Information Exists For End Section In MA <br>
	 * Length: 1
	 */
	public static final boolean Q_ENDTIMER         = BOOLEAN_NOVALUE;
	public static final boolean Q_ENDTIMER_NO_INFO = false;
	public static final boolean Q_ENDTIMER_INFO    = true;

	/**
	 * Name: Q_FRONT <br>
	 * Description: Validity End Point Of Profile Element <br>
	 * Length: 1
	 */
	public static final boolean Q_FRONT             = BOOLEAN_NOVALUE;
	public static final boolean Q_FRONT_TRAIN_END   = false;
	public static final boolean Q_FRONT_TRAIN_FRONT = true;

	/**
	 * Name: Q_GDIR <br>
 	 * Description: Qualifier For Gradient Slope <br>
	 * Length: 1
	 */
	public static final boolean Q_GDIR          = BOOLEAN_NOVALUE;
	public static final boolean Q_GDIR_DOWNHILL = false;
	public static final boolean Q_GDIR_UPHILL   = true;

	/**
	 * Name: Q_INFILL <br>
	 * Description: Indicates Whether A Train Is Entering Or Exiting The Radio Infill Area <br>
	 * Length: 1
	 */
	public static final boolean Q_INFILL = BOOLEAN_NOVALUE;
	public static final boolean Q_INFILL_ENTER = false;
	public static final boolean Q_INFILL_EXIT  = true;

	/**
	 * Name: Q_LENGTH <br>
	 * Description: Train Integrity Status <br>
	 * Length: 2
	 */
	public static final int Q_LENGTH                                = INTEGER_NOVALUE;
	public static final int Q_LENGTH_INFO_NOT_AVAILABLE             = 0;
	public static final int Q_LENGTH_CONFIRMED_BY_MONITORING_DEVICE = 1;
	public static final int Q_LENGTH_CONFIRMED_BY_DRIVER            = 2;
	public static final int Q_LENGTH_INTEGRITY_LOST                 = 3;

	/**
	 * Name: Q_LGTLOC <br>
	 * Description: Specific Report Location <br>
	 * Length: 1
	 */
	public static final boolean Q_LGTLOC                    = BOOLEAN_NOVALUE;
	public static final boolean Q_LGTLOC_MIN_SAFE_REAR_END  = false;
	public static final boolean Q_LGTLOC_MAX_SAFE_FRONT_END = true;

	/**
	 * Name: Q_LINK <br>
	 * Description: Qualifier Marking A Balise Group As Linked Or Unlinked <br>
	 * Length: 1
	 */
	public static final boolean Q_LINK          = BOOLEAN_NOVALUE;
	public static final boolean Q_LINK_UNLINKED = false;
	public static final boolean Q_LINK_LINKED   = true;

	/**
	 * Name: Q_LOCACC <br>
	 * Description: Accuracy Of The Balise Location <br>
	 * Length: 6 <br>
	 * Min: 0 <br>
	 * Max: 63 <br>
	 * Resolution: 1m
	 */
	public static final int Q_LOCACC = INTEGER_NOVALUE;

	/**
	 * Name: Q_LINKORIENTATION <br>
	 * Description: Indicates Whether The Linked Balise Group Will Be Overpassed In Nominal Or Reverse Direction <br>
	 * Length: 1
	 */
	public static final boolean Q_LINKORIENTATION         = BOOLEAN_NOVALUE;
	public static final boolean Q_LINKORIENTATION_REVERSE = false;
	public static final boolean Q_LINKORIENTATION_NOMINAL = true;

	/**
	 * Name: Q_LINKREACTION <br>
	 * Description: Qualifier For The Reaction To A Message Consistency Problem In A Linked Balise Group <br>
	 * Length: 2
	 */
	public static final int Q_LINKREACTION                     = INTEGER_NOVALUE;
	public static final int Q_LINKREACTION_TRAIN_TRIP          = 0;
	public static final int Q_LINKREACTION_APPLY_SERVICE_BREAK = 1;
	public static final int Q_LINKREACTION_NO_REACTION         = 2;
	public static final int Q_LINKREACTION_SPARE               = 3;

	/**
	 * Name: Q_LOOPDIR <br>
	 * Description: Qualifier To Indicate The Direction Of The Loop <br>
	 * Length: 1
	 */
	public static final boolean Q_LOOPDIR		   = BOOLEAN_NOVALUE;
	public static final boolean Q_LOOPDIR_OPPOSITE = false;
	public static final boolean Q_LOOPDIR_SAME	   = true;

	/**
	 * Name: Q_LSSMA <br>
	 * Description: Qualifier For The LSSMA Display <br>
	 * Length: 1
	 */
	public static final boolean Q_LSSMA		= BOOLEAN_NOVALUE;
	public static final boolean Q_LSSMA_OFF = false;
	public static final boolean Q_LSSMA_ON  = true;

	/**
	 * Name: Q_LXSTATUS <br>
	 * Description: Indicates Whether LX Is Protected Or Not <br>
	 * Length: 1
	 */
	public static final boolean Q_LXSTATUS               = BOOLEAN_NOVALUE;
	public static final boolean Q_LXSTATUS_PROTECTED     = false;
	public static final boolean Q_LXSTATUS_NOT_PROTECTED = true;

	/**
	 * Name: Q_MAMODE <br>
	 * Description: Indicator For Supervision Of Beginning Of Mode Profile <br>
	 * Length: 1
	 */
	public static final boolean Q_MAMODE             = BOOLEAN_NOVALUE;
	public static final boolean Q_MAMODE_EOA         = false;
	public static final boolean Q_MAMODE_EOA_AND_SvL = true;

	/**
	 * Name: Q_MARQSTREASON <br>
	 * Description: Reason for MA request sending <br>
	 * Length: 5
	 * Resolution: Bitset
	 */
	public static final int Q_MARQSTREASON                                = INTEGER_NOVALUE;
	public static final int Q_MARQSTREASON_START_SELECTED_BY_DRIVER       = 1;
	public static final int Q_MARQSTREASON_TIME_BEFORE_REACHING_LOCATION  = 2;
	public static final int Q_MARQSTREASON_TIME_BEFORE_TIMER_EXPIRES      = 4;
	public static final int Q_MARQSTREASON_TRACK_DESCRIPTION_DELETED      = 8;
	public static final int Q_MARQSTREASON_TAF_UP_TO_LEVEL_2_3_TRANSITION = 16;

	/**
	 * Name: Q_MEDIA <br>
	 * Description: Indicates Whether It Is A Balise Telegram Or Loop Message <br>
	 * Length: 1
	 */
	public static final boolean Q_MEDIA        = BOOLEAN_NOVALUE;
	public static final boolean Q_MEDIA_BALISE = false;
	public static final boolean Q_MEDIA_LOOP   = true;

	/**
	 * Name: Q_MPOSITION <br>
	 * Description: Qualifier For Track Kilometre Direction <br>
	 * Length: 1
	 */
	public static final boolean Q_MPOSITION			 = BOOLEAN_NOVALUE;
	public static final boolean Q_MPOSITION_OPPOSITE = BOOLEAN_NOVALUE;
	public static final boolean Q_MPOSITION_SAME	 = BOOLEAN_NOVALUE;

	/**
	 * Name: Q_NEWCOUNTRY <br>
	 * Description: New Country Qualifier <br>
	 * Length: 1
	 */
	public static final boolean Q_NEWCOUNTRY       = BOOLEAN_NOVALUE;
	public static final boolean Q_NEWCOUNTRY_SAME  = false;
	public static final boolean Q_NEWCOUNTRY_OTHER = true;

	/**
	 * Name: Q_NVDRIVER_ADHES <br>
	 * Description: Qualifier For The Modification Of Trackside Adhesion Factor By Driver <br>
	 * Length: 1
	 */
	public static final boolean Q_NVDRIVER_ADHES             = BOOLEAN_NOVALUE;
	public static final boolean Q_NVDRIVER_ADHES_NOT_ALLOWED = false;
	public static final boolean Q_NVDRIVER_ADHES_ALLOWED     = true;

	// Q_NVEMRRLS
	/**
	 * Name: Q_NVEMRRLS <br>
	 * Description: Qualifier For Emergency Brake Release <br>
	 * Length: 1
	 */
	public static final boolean Q_NVEMRRLS                   = BOOLEAN_NOVALUE;
	public static final boolean Q_NVEMRRLS_STANDSTILL        = false;
	public static final boolean Q_NVDRIVER_SUPERVISION_LIMIT = true;

	// Q_NVGUIPERM
	/**
	 * Name: Q_NVGUIPERM <br>
	 * Description: Permission To Use The Guidance Curve <br>
	 * Length: 1
	 */
	public static final boolean Q_NVGUIPERM     = BOOLEAN_NOVALUE;
	public static final boolean Q_NVGUIPERM_No  = false;
	public static final boolean Q_NVGUIPERM_YES = true;

	// Q_NVINHSMICPERM
	/**
	 * Name: Q_NVINHSMICPERM <br>
	 * Description: Permission To Inhibit The Compensation Of The Speed Measurement Inaccuracy <br>
	 * Length: 1
	 */
	public static final boolean Q_NVINHSMICPERM     = BOOLEAN_NOVALUE;
	public static final boolean Q_NVINHSMICPERM_NO  = false;
	public static final boolean Q_NVINHSMICPERM_YES = true;

	// Q_NVKINT
	/**
	 * Name: Q_NVKINT <br>
	 * Description: Qualifier For Integrated Correction Factors <br>
	 * Length: 1
	 */
	public static final boolean Q_NVKINT                       = BOOLEAN_NOVALUE;
	public static final boolean Q_NVKINT_NO_INTEGRATED_FACTORS = false;
	public static final boolean Q_NVKINT_INTEGRATED_FACTORS    = true;

	// Q_NVKVINTSET
	/**
	 * Name: Q_NVKVINTSET <br>
	 * Description: Type Of Kv_int Set <br>
	 * Length: 2 <br>
	 * 3-4: Spare
	 */
	public static final int Q_NVKVINTSET                  = INTEGER_NOVALUE;
	public static final int Q_NVKVINTSET_FREIGHT_TRAINS   = 0;
	public static final int Q_NVKVINTSET_PASSENGER_TRAINS = 1;

	// Q_NVLOCACC
	/**
	 * Name: Q_NVLOCACC <br>
	 * Description: Default Accuracy Of The Balise Location (Absolute Value) <br>
	 * Length: 6 <br>
	 * Min: 0 <br>
	 * Max: 63 m <br>
	 * Resolution: 1 m
	 */
	public static final int Q_NVLOCACC = INTEGER_NOVALUE;

	// Q_NVSBFBPERM
	/**
	 * Name: Q_NVSBFBPERM <br>
	 * Description: Permission To Use The Service Brake Feedback <br>
	 * Length: 1
	 */
	public static final boolean Q_NVSBFBPERM     = BOOLEAN_NOVALUE;
	public static final boolean Q_NVSBFBPERM_NO  = false;
	public static final boolean Q_NVSBFBPERM_YES = true;

	// Q_NVSBTSMPERM
	/**
	 * Name: Q_NVSBTSMPERM <br>
	 * Description: Permission To Use Service Brake In Target Speed Monitoring <br>
	 * Length: 1
	 */
	public static final boolean Q_NVSBTSMPERM     = BOOLEAN_NOVALUE;
	public static final boolean Q_NVSBTSMPERM_NO  = false;
	public static final boolean Q_NVSBTSMPERM_YES = true;

	/**
	 * Name: Q_ORIENTATION <br>
	 * Description: Coordinate System Assigned To A Single BG <br>
	 * Length: 1
	 */
	public static final boolean Q_ORIENTATION = BOOLEAN_NOVALUE;
	public static final boolean Q_ORIENTATION_REVERSE = false;
	public static final boolean Q_ORIENTATION_NOMINAL = true;

	/**
	 * Name: Q_OVERLAP <br>
	 * Description: Indicates Whether There Is An Overlap <br>
	 * Length: 1
	 */
	public static final boolean Q_OVERLAP         = BOOLEAN_NOVALUE;
	public static final boolean Q_OVERLAP_NO_INFO = false;
	public static final boolean Q_OVERLAP_INFO    = true;

	/**
	 * Name: Q_PBDSR <br>
	 * Description: Permitted Braking Distance <br>
	 * Length: 1
	 */
	public static final boolean Q_PBDSR                 = BOOLEAN_NOVALUE;
	public static final boolean Q_PBDSR_EMERGENCY_BRAKE = false;
	public static final boolean Q_PBDSR_SERVICE_BRAKE   = true;

	/**
	 * Name: Q_PLATFORM <br>
	 * Description: Platform Position Relative To Direction Of MA <br>
	 * Length: 2
	 */
	public static final int Q_PLATFORM       = INTEGER_NOVALUE;
	public static final int Q_PLATFORM_LEFT  = 0;
	public static final int Q_PLATFORM_RIGHT = 1;
	public static final int Q_PLATFORM_BOTH  = 2;

	/**
	 * Name: Q_RBC <br>
	 * Description: Qualifier For Communication Session Order <br>
	 * Length: 1
	 */
	public static final boolean Q_RBC 			= BOOLEAN_NOVALUE;
	public static final boolean Q_RBC_TERMINATE = false;
	public static final boolean Q_RBC_ESTABLISH = true;

	/**
	 * Name: Q_RIU <br>
	 * Description: Qualifier For Communication Session Order <br>
	 * Length: 1
	 */
	public static final boolean Q_RIU 			= BOOLEAN_NOVALUE;
	public static final boolean Q_RIU_TERMINATE = false;
	public static final boolean Q_RIU_ESTABLISH = true;

	/**
	 * Name: Q_SCALE <br>
	 * Description: Distance Scale Qualifier <br>
	 * Length: 2
	 */
	public static final int Q_SCALE = INTEGER_NOVALUE;
	public static final int Q_SCALE_10CM = 0;
	public static final int Q_SCALE_1M   = 1;
	public static final int Q_SCALE_10M  = 2;

	/**
	 * Name: Q_SECTIONTIMER <br>
	 * Description: Indicates Whether There Is A Section Time-Out Related To Section <br>
	 * Length: 1
	 */
	public static final boolean Q_SECTIONTIMER         = BOOLEAN_NOVALUE;
	public static final boolean Q_SECTIONTIMER_NO_INFO = false;
	public static final boolean Q_SECTIONTIMER_INFO    = true;

	/**
	 * Name: Q_SLEEPSESSION <br>
	 * Description: Session Management For Sleeping Equipment <br>
	 * Length: 1
	 */
	public static final boolean Q_SLEEPSESSION 			= BOOLEAN_NOVALUE;
	public static final boolean Q_SLEEPSESSION_IGNORE   = false;
	public static final boolean Q_SLEEPSESSION_EXECUTE  = true;

	/**
	 * Name: Q_SRSTOP <br>
	 * Description: "STOP IF IN STAFF RESPONSIBLE" INFORMATION <br>
	 * Length: 1
	 */
	public static final boolean Q_SRSTOP               = BOOLEAN_NOVALUE;
	public static final boolean Q_SRSTOP_STOP_IF_IN_SR = false;
	public static final boolean Q_SRSTOP_GO_IF_IN_SR   = true;

	/**
	 * Name: Q_SSCODE <br>
	 * Description: Spread Spectrum Code For Euroloop <br>
	 * Length: 4 <br>
	 * Min: 0 <br>
	 * Max: 14
	 */
	public static final int Q_SSCODE 			  = INTEGER_NOVALUE;
	public static final int Q_SSCODE_TEST_PURPOSE = 15;

	/**
	 * Name: Q_STATUS <br>
	 * Description: Status Of SoM Position Report <br>
	 * Length: 2
	 */
	public static final int Q_STATUS = INTEGER_NOVALUE;
	public static final int Q_STATUS_INVALID = 0;
	public static final int Q_STATUS_VALID   = 1;
	public static final int Q_STATUS_UNKNOWN = 2;
	public static final int Q_STATUS_SPARE   = 3;

	/**
	 * Name: Q_STOPLX <br>
	 * Description: Indicates Whether Stopping Train In Rear Of Non Protected LX Is Required <br>
	 * Length: 1
	 */
	public static final boolean Q_STOPLX               = BOOLEAN_NOVALUE;
	public static final boolean Q_STOPLX_NOT_REQUIRED  = false;
	public static final boolean Q_STOPLX_STOP_REQUIRED = true;

	/**
	 * Name: Q_SUITABILITY <br>
	 * Description: Type Of Route Suitability Data <br>
	 * Length: 2
	 */
	public static final int Q_SUITABILITY                 = INTEGER_NOVALUE;
	public static final int Q_SUITABILITY_LOADING_GAUGE   = 0;
	public static final int Q_SUITABILITY_MAX_AXLE_LOAD   = 1;
	public static final int Q_SUITABILITY_TRACTION_SYSTEM = 2;

	/**
	 * Name: Q_TEXT <br>
	 * Description: Fixed Message To Be Displayed <br>
	 * Length: 8 <br>
	 * 2 - 255: Spare
	 */
	public static final int Q_TEXT                 				  = INTEGER_NOVALUE;
	public static final int Q_TEXT_LEVEL_CROSSING_NOT_PROTECTED   = 0;
	public static final int Q_TEXT_ACKNOWLEDGEMENT				  = 1;

	/**
	 * Name: Q_TEXTCLASS <br>
	 * Description: Class Of Message To Be Displayed <br>
	 * Length: 2
	 */
	public static final int Q_TEXTCLASS                = INTEGER_NOVALUE;
	public static final int Q_TEXTCLASS_AUXILIARY_INFO = 0;
	public static final int Q_TEXTCLASS_IMPORTANT_INFO = 1;

	/**
	 * Name: Q_TEXTCONFIRM <br>
	 * Description: Qualifier For Text Confirmation <br>
	 * Length: 2
	 */
	public static final int Q_TEXTCONFIRM				  = INTEGER_NOVALUE;
	public static final int Q_TEXTCONFIRM_NO_CONF		  = 0;
	public static final int Q_TEXTCONFIRM_CONF			  = 1;
	public static final int Q_TEXTCONFIRM_SERVICE_BREAK   = 2;
	public static final int Q_TEXTCONFIRM_EMERGENCY_BREAK = 3;

	/**
	 * Name: Q_TEXTDISPLAY <br>
	 * Description: Qualifier For The Combination Of Text Message Events <br>
	 * Length: 1
	 */
	public static final boolean Q_TEXTDISPLAY               	= BOOLEAN_NOVALUE;
	public static final boolean Q_TEXTDISPLAY_NO_ONE_FULFILLED  = false;
	public static final boolean Q_TEXTDISPLAY_YES_ALL_FULFILLED = true;

	/**
	 * Name: Q_TEXTREPORT <br>
	 * Description: Qualifier For Reporting Acknowledgement Of Text By Driver <br>
	 * Length: 1
	 */
	public static final boolean Q_TEXTREPORT		= BOOLEAN_NOVALUE;
	public static final boolean Q_TEXTREPORT_NO_ACK = false;
	public static final boolean Q_TEXTREPORT_ACK	= true;

	/**
	 * Name: Q_TRACKINIT <br>
	 * Description: Qualifier For Resuming Initial States Of Related Track Description <br>
	 * Length: 1
	 */
	public static final boolean Q_TRACKINIT                   = BOOLEAN_NOVALUE;
	public static final boolean Q_TRACKINIT_PROFILE_TO_FOLLOW = false;
	public static final boolean Q_TRACKINIT_EMPTY_PROFILE     = true;

	/**
	 * Name: Q_UPDOWN <br>
	 * Description: Balise Telegram Transmission Direction <br>
	 * Length 1
	 */
	public static final boolean Q_UPDOWN           = BOOLEAN_NOVALUE;
	public static final boolean Q_UPDOWN_DOWN_LINK = false;
	public static final boolean Q_UPDOWN_UP_LINK   = true;

	/**
	 * Name: Q_VBCO <br>
	 * Description: Qualifier For Virtual Balise Cover Order <br>
	 * Length 1
	 */
	public static final boolean Q_VBCO		  = BOOLEAN_NOVALUE;
	public static final boolean Q_VBCO_REMOVE = false;
	public static final boolean Q_VBCO_SET	  = true;



	// ---------
	// Time/Date
	// ---------

	/**
	 * Name: T_CYCLOC <br>
	 * Description: Time Interval Between Two Position Reports <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 254 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_CYCLOC          = INTEGER_NOVALUE;
	public static final int T_CYCLOC_INFINITY = 255;

	/**
	 * Name: T_CYCRQST <br>
	 * Description: Time Between Two Cyclic Requests For A MA <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 254 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_CYCRQST          = INTEGER_NOVALUE;
	public static final int T_CYCRQST_INFINITY = 255;

	/**
	 * Name: T_ENDTIMER <br>
	 * Description: Validity Time For End Section In MA <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1022 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_ENDTIMER          = INTEGER_NOVALUE;
	public static final int T_ENDTIMER_INFINITY = 1023;

	/**
	 * Name: T_LOA <br>
	 * Description: Validity Time For Target Speed At LOA <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1022 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_LOA          = INTEGER_NOVALUE;
	public static final int T_LOA_INFINITY = 1023;

	/**
	 * Name: T_LSSMA <br>
	 * Description: Delay To Toggle On The LSSMA Display <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 255 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_LSSMA = INTEGER_NOVALUE;

	/**
	 * Name: T_MAR <br>
	 * Description: Time Before Reaching Pre-Indication Location For EOA/LOA <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 254 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_MAR          = INTEGER_NOVALUE;
	public static final int T_MAR_INFINITY = 255;

	/**
	 * Name: T_NVCONTACT <br>
	 * Description: Maximal Time Without New "Safe" Message <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 254 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_NVCONTACT          = INTEGER_NOVALUE;
	public static final int T_NVCONTACT_INFINITY = 255;

	/**
	 * Name: T_NVOVTRP <br>
	 * Description: Maximal Time For Overriding The Train Trip <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 255 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_NVOVTRP = INTEGER_NOVALUE;

	/**
	 * Name: T_OL <br>
	 * Description: Overlap Validity Time <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1022 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_OL          = INTEGER_NOVALUE;
	public static final int T_OL_INFINITY = 1023;

	/**
	 * Name: T_SECTIONTIMER <br>
	 * Description: Validity Time Of Section In MA <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1022 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_SECTIONTIMER          = INTEGER_NOVALUE;
	public static final int T_SECTIONTIMER_INFINITY = 1023;

	/**
	 * Name: T_TEXTDISPLAY <br>
	 * Description: Duration For Which A Text Shall Be Displayed <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1022 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_TEXTDISPLAY				   = INTEGER_NOVALUE;
	public static final int T_TEXTDISPLAY_NOT_TIME_LIMITED = 1023;

	/**
	 * Name: T_TIMEOUTRQST <br>
	 * Description: Time Before Any Section Timer Expires Or The LOA Speed Timer Expires <br>
	 * Length: 10 <br>
	 * Min: 0 <br>
	 * Max: 1022 s <br>
	 * Resolution: 1 s
	 */
	public static final int T_TIMEOUTRQST          = INTEGER_NOVALUE;
	public static final int T_TIMEOUTRQST_INFINITY = 1023;

	/**
	 * Name: T_TRAIN <br>
	 * Description: Time, According To Trainborne Clock, At Which Message Is Sent <br>
	 * Length: 32 <br>
	 * Min: 0 <br>
	 * Max: 42949672.94 s <br>
	 * Resolution: 10 ms
	 */
	public static final long T_TRAIN         = INTEGER_NOVALUE;
	public static final long T_TRAIN_UNKNOWN = 4294967295L;

	/**
	 * Name: T_VBC <br>
	 * Description: VBC Validity Period <br>
	 * Length: 8 <br>
	 * Min: 0 <br>
	 * Max: 255 days <br>
	 * Resolution: 1 days
	 */
	public static final int T_VBC = INTEGER_NOVALUE;



	// -----
	// Speed
	// -----

	/**
	 * Name: V_AXLELOAD <br>
	 * Description: Speed Restriction Related To Axleload <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_AXLELOAD = INTEGER_NOVALUE;

	/**
	 * Name: V_DIFF <br>
	 * Description: Absolute Positive Speed Associated To Train Category <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_DIFF = INTEGER_NOVALUE;

	/**
	 * Name: V_LOA <br>
	 * Description: Permitted Speed At Limit Of Authority <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_LOA = INTEGER_NOVALUE;

	/**
	 * Name: V_LX <br>
	 * Description: Permitted Speed For LX Speed Restriction <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_LX = INTEGER_NOVALUE;

	/**
	 * Name: V_MAIN <br>
	 * Description: Signalling Related Speed Restriction <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * 121-127: Spare <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_MAIN = INTEGER_NOVALUE;
	public static final int V_MAIN_TRIP_ORDER = 0;

	/**
	 * Name: V_MAMODE <br>
	 * Description: Required Mode Related Speed <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_MAMODE          = INTEGER_NOVALUE;
	public static final int V_MAMODE_NATIONAL = 127;

	/**
	 * Name: V_MAXTRAIN <br>
	 * Description: Maximum Train Speed <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_MAXTRAIN = INTEGER_NOVALUE;

	/**
	 * Name: V_NVALLOWOVTRP <br>
	 * Description: Speed Limit Allowing The Driver To Select The "Override" Function <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h <br>
	 * 121-127: Spare
	 */
	public static final int V_NVALLOWOVTRP = INTEGER_NOVALUE;

	/**
	 * Name: V_NVKVINT <br>
	 * Description: Speed Step Used To Define The Integrated Correction Factor Kv <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h <br>
	 * 121-127: Spare
	 */
	public static final int V_NVKVINT = INTEGER_NOVALUE;

	/**
	 * Name: V_NVLIMSUPERV <br>
	 * Description: Limited Supervision Mode Speed Limit <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h <br>
	 * 121-127: Spare
	 */
	public static final int V_NVLIMSUPERV = INTEGER_NOVALUE;

	/**
	 * Name: V_NVONSIGHT <br>
	 * Description: On Sight Mode Speed Limit <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h <br>
	 * 121-127: Spare
	 */
	public static final int V_NVONSIGHT = INTEGER_NOVALUE;

	/**
	 * Name: V_NVSUPOVTRP <br>
	 * Description: Override Speed Limit To Be Supervised When The "Override" Function Is Active <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h <br>
	 * 121-127: Spare
	 */
	public static final int V_NVSUPOVTRP = INTEGER_NOVALUE;

	/**
	 * Name: V_NVREL <br>
	 * Description: Release Speed <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h <br>
	 * 121-127: Spare
	 */
	public static final int V_NVREL = INTEGER_NOVALUE;

	/**
	 * Name: V_NVSHUNT <br>
	 * Description: Shunting Mode Speed Limit <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h <br>
	 * 121-127: Spare
	 */
	public static final int V_NVSHUNT = INTEGER_NOVALUE;

	/**
	 * Name: V_NVSTFF <br>
	 * Description: Staff Responsible Mode Speed Limit <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h <br>
	 * 121-127: Spare
	 */
	public static final int V_NVSTFF = INTEGER_NOVALUE;

	/**
	 * Name: V_NVUNFIT <br>
	 * Description: Unfitted Mode Speed Limit <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h <br>
	 * 121-127: Spare
	 */
	public static final int V_NVUNFIT = INTEGER_NOVALUE;

	/**
	 * Name: V_RELEASEDP <br>
	 * Description: Release Speed Associated With Danger Point <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_RELEASEDP          = INTEGER_NOVALUE;
	public static final int V_RELEASEDP_ONBOARD  = 126;
	public static final int V_RELEASEDP_NATIONAL = 127;

	/**
	 * Name: V_RELEASEOL <br>
	 * Description: Release Speed Associated With Overlap <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_RELEASEOL          = INTEGER_NOVALUE;
	public static final int V_RELEASEOL_ONBOARD  = 126;
	public static final int V_RELEASEOL_NATIONAL = 127;

	/**
	 * Name: V_REVERSE <br>
	 * Description: Reversing Mode Speed Limit <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_REVERSE = INTEGER_NOVALUE;

	/**
	 * Name: V_STATIC <br>
	 * Description: Basic Static Speed Profile <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_STATIC                 = INTEGER_NOVALUE;
	public static final int V_STATIC_END_DESCRIPTION = 127;

	/**
	 * Name: V_TRAIN <br>
	 * Description: Train Speed <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_TRAIN = INTEGER_NOVALUE;

	/**
	 * Name: V_TSR <br>
	 * Description: Permitted Speed For Temporary Speed Restriction <br>
	 * Length: 7 <br>
	 * Min: 0 <br>
	 * Max: 600 km/h <br>
	 * Resolution: 5 km/h
	 */
	public static final int V_TSR = INTEGER_NOVALUE;



	// ----
	// Text
	// ----

	/**
	 * Name: X_TEXT <br>
	 * Description: Text String Element <br>
	 * Length: 8 <br>
	 * Resolution: Character encoded as ISO 8859-1
	 */
	public static final int X_TEXT = INTEGER_NOVALUE;

}