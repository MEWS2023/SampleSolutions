package ac.at.tuwien.big.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ac.at.tuwien.big.services.ScmlGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalScmlParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'SmartCity'", "'{'", "'categories'", "'['", "','", "']'", "'projects'", "'}'", "'('", "'SDG'", "'='", "')'", "'belongsTo'", "'components'", "'indicators'", "'-'", "'status'", "'parameter'", "'lastCalculation'", "'nextCalculation'", "'lat'", "'long'", "'DataValue'", "'collected'", "'dType'", "'value'", "'producedTime'", "'consumedTime'", "'unit'", "'type'", "'goalValue'", "':'", "'dataSource'", "'observedValue'", "'BuildingComponent'", "'buildingComponentSuper'", "'buildingComponentSub'", "'buildingComponentLocation'", "'buildingComponentData'", "'buildingComponentParameter'", "'buildingComponentDevices'", "'TransportationComponent'", "'transportationComponentSuper'", "'transportationComponentSub'", "'transportComponentLocation'", "'transportComponentData'", "'transportComponentParameter'", "'transportComponentDevices'", "'EnvironmentalComponent'", "'environmentalComponentSuper'", "'environmentalComponentSub'", "'environmentalComponentLocation'", "'environmentalComponentData'", "'environmentalComponentParameter'", "'environmentalComponentDevices'", "'.'", "'E'", "'e'", "'GoalValue'", "'basedOn'", "'->'", "'aggregatorType'", "'aggregatedTime'", "'Basis'", "'description'", "'principleType'", "'source'", "'Sensor'", "'Actuator'", "'STRING'", "'BOOL'", "'INTEGER'", "'FLOAT'", "'AIRQUALITY'", "'WEATHER'", "'TRAFFIC'", "'ENERGY'", "'AGRICULTURAL'", "'NAVIGATION'", "'WASTEMANAGEMENT'", "'SAFETY'", "'LAW'", "'STANDARD'", "'POLICY'", "'SUM'", "'DIFF'", "'AVG'", "'MIN'", "'MAX'", "'GOOD'", "'WARN'", "'CRITICAL'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalScmlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalScmlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalScmlParser.tokenNames; }
    public String getGrammarFileName() { return "InternalScml.g"; }



     	private ScmlGrammarAccess grammarAccess;

        public InternalScmlParser(TokenStream input, ScmlGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "SmartCity";
       	}

       	@Override
       	protected ScmlGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSmartCity"
    // InternalScml.g:65:1: entryRuleSmartCity returns [EObject current=null] : iv_ruleSmartCity= ruleSmartCity EOF ;
    public final EObject entryRuleSmartCity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSmartCity = null;


        try {
            // InternalScml.g:65:50: (iv_ruleSmartCity= ruleSmartCity EOF )
            // InternalScml.g:66:2: iv_ruleSmartCity= ruleSmartCity EOF
            {
             newCompositeNode(grammarAccess.getSmartCityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSmartCity=ruleSmartCity();

            state._fsp--;

             current =iv_ruleSmartCity; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSmartCity"


    // $ANTLR start "ruleSmartCity"
    // InternalScml.g:72:1: ruleSmartCity returns [EObject current=null] : ( () otherlv_1= 'SmartCity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'categories' otherlv_5= '[' ( (lv_category_6_0= ruleCategory ) ) (otherlv_7= ',' ( (lv_category_8_0= ruleCategory ) ) )* otherlv_9= ']' )? (otherlv_10= 'projects' otherlv_11= '[' ( (lv_project_12_0= ruleProject ) ) (otherlv_13= ',' ( (lv_project_14_0= ruleProject ) ) )* otherlv_15= ']' )? otherlv_16= '}' ) ;
    public final EObject ruleSmartCity() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_category_6_0 = null;

        EObject lv_category_8_0 = null;

        EObject lv_project_12_0 = null;

        EObject lv_project_14_0 = null;



        	enterRule();

        try {
            // InternalScml.g:78:2: ( ( () otherlv_1= 'SmartCity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'categories' otherlv_5= '[' ( (lv_category_6_0= ruleCategory ) ) (otherlv_7= ',' ( (lv_category_8_0= ruleCategory ) ) )* otherlv_9= ']' )? (otherlv_10= 'projects' otherlv_11= '[' ( (lv_project_12_0= ruleProject ) ) (otherlv_13= ',' ( (lv_project_14_0= ruleProject ) ) )* otherlv_15= ']' )? otherlv_16= '}' ) )
            // InternalScml.g:79:2: ( () otherlv_1= 'SmartCity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'categories' otherlv_5= '[' ( (lv_category_6_0= ruleCategory ) ) (otherlv_7= ',' ( (lv_category_8_0= ruleCategory ) ) )* otherlv_9= ']' )? (otherlv_10= 'projects' otherlv_11= '[' ( (lv_project_12_0= ruleProject ) ) (otherlv_13= ',' ( (lv_project_14_0= ruleProject ) ) )* otherlv_15= ']' )? otherlv_16= '}' )
            {
            // InternalScml.g:79:2: ( () otherlv_1= 'SmartCity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'categories' otherlv_5= '[' ( (lv_category_6_0= ruleCategory ) ) (otherlv_7= ',' ( (lv_category_8_0= ruleCategory ) ) )* otherlv_9= ']' )? (otherlv_10= 'projects' otherlv_11= '[' ( (lv_project_12_0= ruleProject ) ) (otherlv_13= ',' ( (lv_project_14_0= ruleProject ) ) )* otherlv_15= ']' )? otherlv_16= '}' )
            // InternalScml.g:80:3: () otherlv_1= 'SmartCity' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'categories' otherlv_5= '[' ( (lv_category_6_0= ruleCategory ) ) (otherlv_7= ',' ( (lv_category_8_0= ruleCategory ) ) )* otherlv_9= ']' )? (otherlv_10= 'projects' otherlv_11= '[' ( (lv_project_12_0= ruleProject ) ) (otherlv_13= ',' ( (lv_project_14_0= ruleProject ) ) )* otherlv_15= ']' )? otherlv_16= '}'
            {
            // InternalScml.g:80:3: ()
            // InternalScml.g:81:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSmartCityAccess().getSmartCityAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getSmartCityAccess().getSmartCityKeyword_1());
            		
            // InternalScml.g:91:3: ( (lv_name_2_0= ruleEString ) )
            // InternalScml.g:92:4: (lv_name_2_0= ruleEString )
            {
            // InternalScml.g:92:4: (lv_name_2_0= ruleEString )
            // InternalScml.g:93:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSmartCityAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_4);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSmartCityRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_5); 

            			newLeafNode(otherlv_3, grammarAccess.getSmartCityAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalScml.g:114:3: (otherlv_4= 'categories' otherlv_5= '[' ( (lv_category_6_0= ruleCategory ) ) (otherlv_7= ',' ( (lv_category_8_0= ruleCategory ) ) )* otherlv_9= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalScml.g:115:4: otherlv_4= 'categories' otherlv_5= '[' ( (lv_category_6_0= ruleCategory ) ) (otherlv_7= ',' ( (lv_category_8_0= ruleCategory ) ) )* otherlv_9= ']'
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_6); 

                    				newLeafNode(otherlv_4, grammarAccess.getSmartCityAccess().getCategoriesKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,14,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getSmartCityAccess().getLeftSquareBracketKeyword_4_1());
                    			
                    // InternalScml.g:123:4: ( (lv_category_6_0= ruleCategory ) )
                    // InternalScml.g:124:5: (lv_category_6_0= ruleCategory )
                    {
                    // InternalScml.g:124:5: (lv_category_6_0= ruleCategory )
                    // InternalScml.g:125:6: lv_category_6_0= ruleCategory
                    {

                    						newCompositeNode(grammarAccess.getSmartCityAccess().getCategoryCategoryParserRuleCall_4_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_category_6_0=ruleCategory();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSmartCityRule());
                    						}
                    						add(
                    							current,
                    							"category",
                    							lv_category_6_0,
                    							"ac.at.tuwien.big.Scml.Category");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalScml.g:142:4: (otherlv_7= ',' ( (lv_category_8_0= ruleCategory ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==15) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalScml.g:143:5: otherlv_7= ',' ( (lv_category_8_0= ruleCategory ) )
                    	    {
                    	    otherlv_7=(Token)match(input,15,FOLLOW_3); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getSmartCityAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalScml.g:147:5: ( (lv_category_8_0= ruleCategory ) )
                    	    // InternalScml.g:148:6: (lv_category_8_0= ruleCategory )
                    	    {
                    	    // InternalScml.g:148:6: (lv_category_8_0= ruleCategory )
                    	    // InternalScml.g:149:7: lv_category_8_0= ruleCategory
                    	    {

                    	    							newCompositeNode(grammarAccess.getSmartCityAccess().getCategoryCategoryParserRuleCall_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_category_8_0=ruleCategory();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getSmartCityRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"category",
                    	    								lv_category_8_0,
                    	    								"ac.at.tuwien.big.Scml.Category");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,16,FOLLOW_8); 

                    				newLeafNode(otherlv_9, grammarAccess.getSmartCityAccess().getRightSquareBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalScml.g:172:3: (otherlv_10= 'projects' otherlv_11= '[' ( (lv_project_12_0= ruleProject ) ) (otherlv_13= ',' ( (lv_project_14_0= ruleProject ) ) )* otherlv_15= ']' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalScml.g:173:4: otherlv_10= 'projects' otherlv_11= '[' ( (lv_project_12_0= ruleProject ) ) (otherlv_13= ',' ( (lv_project_14_0= ruleProject ) ) )* otherlv_15= ']'
                    {
                    otherlv_10=(Token)match(input,17,FOLLOW_6); 

                    				newLeafNode(otherlv_10, grammarAccess.getSmartCityAccess().getProjectsKeyword_5_0());
                    			
                    otherlv_11=(Token)match(input,14,FOLLOW_9); 

                    				newLeafNode(otherlv_11, grammarAccess.getSmartCityAccess().getLeftSquareBracketKeyword_5_1());
                    			
                    // InternalScml.g:181:4: ( (lv_project_12_0= ruleProject ) )
                    // InternalScml.g:182:5: (lv_project_12_0= ruleProject )
                    {
                    // InternalScml.g:182:5: (lv_project_12_0= ruleProject )
                    // InternalScml.g:183:6: lv_project_12_0= ruleProject
                    {

                    						newCompositeNode(grammarAccess.getSmartCityAccess().getProjectProjectParserRuleCall_5_2_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_project_12_0=ruleProject();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSmartCityRule());
                    						}
                    						add(
                    							current,
                    							"project",
                    							lv_project_12_0,
                    							"ac.at.tuwien.big.Scml.Project");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalScml.g:200:4: (otherlv_13= ',' ( (lv_project_14_0= ruleProject ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalScml.g:201:5: otherlv_13= ',' ( (lv_project_14_0= ruleProject ) )
                    	    {
                    	    otherlv_13=(Token)match(input,15,FOLLOW_9); 

                    	    					newLeafNode(otherlv_13, grammarAccess.getSmartCityAccess().getCommaKeyword_5_3_0());
                    	    				
                    	    // InternalScml.g:205:5: ( (lv_project_14_0= ruleProject ) )
                    	    // InternalScml.g:206:6: (lv_project_14_0= ruleProject )
                    	    {
                    	    // InternalScml.g:206:6: (lv_project_14_0= ruleProject )
                    	    // InternalScml.g:207:7: lv_project_14_0= ruleProject
                    	    {

                    	    							newCompositeNode(grammarAccess.getSmartCityAccess().getProjectProjectParserRuleCall_5_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_7);
                    	    lv_project_14_0=ruleProject();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getSmartCityRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"project",
                    	    								lv_project_14_0,
                    	    								"ac.at.tuwien.big.Scml.Project");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,16,FOLLOW_10); 

                    				newLeafNode(otherlv_15, grammarAccess.getSmartCityAccess().getRightSquareBracketKeyword_5_4());
                    			

                    }
                    break;

            }

            otherlv_16=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_16, grammarAccess.getSmartCityAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSmartCity"


    // $ANTLR start "entryRuleInfrastructureComponent"
    // InternalScml.g:238:1: entryRuleInfrastructureComponent returns [EObject current=null] : iv_ruleInfrastructureComponent= ruleInfrastructureComponent EOF ;
    public final EObject entryRuleInfrastructureComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfrastructureComponent = null;


        try {
            // InternalScml.g:238:64: (iv_ruleInfrastructureComponent= ruleInfrastructureComponent EOF )
            // InternalScml.g:239:2: iv_ruleInfrastructureComponent= ruleInfrastructureComponent EOF
            {
             newCompositeNode(grammarAccess.getInfrastructureComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInfrastructureComponent=ruleInfrastructureComponent();

            state._fsp--;

             current =iv_ruleInfrastructureComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfrastructureComponent"


    // $ANTLR start "ruleInfrastructureComponent"
    // InternalScml.g:245:1: ruleInfrastructureComponent returns [EObject current=null] : (this_BuildingComponent_0= ruleBuildingComponent | this_TransportationComponent_1= ruleTransportationComponent | this_EnvironmentalComponent_2= ruleEnvironmentalComponent ) ;
    public final EObject ruleInfrastructureComponent() throws RecognitionException {
        EObject current = null;

        EObject this_BuildingComponent_0 = null;

        EObject this_TransportationComponent_1 = null;

        EObject this_EnvironmentalComponent_2 = null;



        	enterRule();

        try {
            // InternalScml.g:251:2: ( (this_BuildingComponent_0= ruleBuildingComponent | this_TransportationComponent_1= ruleTransportationComponent | this_EnvironmentalComponent_2= ruleEnvironmentalComponent ) )
            // InternalScml.g:252:2: (this_BuildingComponent_0= ruleBuildingComponent | this_TransportationComponent_1= ruleTransportationComponent | this_EnvironmentalComponent_2= ruleEnvironmentalComponent )
            {
            // InternalScml.g:252:2: (this_BuildingComponent_0= ruleBuildingComponent | this_TransportationComponent_1= ruleTransportationComponent | this_EnvironmentalComponent_2= ruleEnvironmentalComponent )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 45:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
                {
                alt5=1;
                }
                break;
            case 18:
                {
                alt5=1;
                }
                break;
            case 52:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
                {
                alt5=2;
                }
                break;
            case 59:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalScml.g:253:3: this_BuildingComponent_0= ruleBuildingComponent
                    {

                    			newCompositeNode(grammarAccess.getInfrastructureComponentAccess().getBuildingComponentParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BuildingComponent_0=ruleBuildingComponent();

                    state._fsp--;


                    			current = this_BuildingComponent_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalScml.g:262:3: this_TransportationComponent_1= ruleTransportationComponent
                    {

                    			newCompositeNode(grammarAccess.getInfrastructureComponentAccess().getTransportationComponentParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_TransportationComponent_1=ruleTransportationComponent();

                    state._fsp--;


                    			current = this_TransportationComponent_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalScml.g:271:3: this_EnvironmentalComponent_2= ruleEnvironmentalComponent
                    {

                    			newCompositeNode(grammarAccess.getInfrastructureComponentAccess().getEnvironmentalComponentParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnvironmentalComponent_2=ruleEnvironmentalComponent();

                    state._fsp--;


                    			current = this_EnvironmentalComponent_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfrastructureComponent"


    // $ANTLR start "entryRuleDevice"
    // InternalScml.g:283:1: entryRuleDevice returns [EObject current=null] : iv_ruleDevice= ruleDevice EOF ;
    public final EObject entryRuleDevice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDevice = null;


        try {
            // InternalScml.g:283:47: (iv_ruleDevice= ruleDevice EOF )
            // InternalScml.g:284:2: iv_ruleDevice= ruleDevice EOF
            {
             newCompositeNode(grammarAccess.getDeviceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDevice=ruleDevice();

            state._fsp--;

             current =iv_ruleDevice; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDevice"


    // $ANTLR start "ruleDevice"
    // InternalScml.g:290:1: ruleDevice returns [EObject current=null] : (this_Sensor_0= ruleSensor | this_Actuator_1= ruleActuator ) ;
    public final EObject ruleDevice() throws RecognitionException {
        EObject current = null;

        EObject this_Sensor_0 = null;

        EObject this_Actuator_1 = null;



        	enterRule();

        try {
            // InternalScml.g:296:2: ( (this_Sensor_0= ruleSensor | this_Actuator_1= ruleActuator ) )
            // InternalScml.g:297:2: (this_Sensor_0= ruleSensor | this_Actuator_1= ruleActuator )
            {
            // InternalScml.g:297:2: (this_Sensor_0= ruleSensor | this_Actuator_1= ruleActuator )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==78) ) {
                alt6=1;
            }
            else if ( (LA6_0==79) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalScml.g:298:3: this_Sensor_0= ruleSensor
                    {

                    			newCompositeNode(grammarAccess.getDeviceAccess().getSensorParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Sensor_0=ruleSensor();

                    state._fsp--;


                    			current = this_Sensor_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalScml.g:307:3: this_Actuator_1= ruleActuator
                    {

                    			newCompositeNode(grammarAccess.getDeviceAccess().getActuatorParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Actuator_1=ruleActuator();

                    state._fsp--;


                    			current = this_Actuator_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDevice"


    // $ANTLR start "entryRuleEString"
    // InternalScml.g:319:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalScml.g:319:47: (iv_ruleEString= ruleEString EOF )
            // InternalScml.g:320:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalScml.g:326:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalScml.g:332:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalScml.g:333:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalScml.g:333:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalScml.g:334:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalScml.g:342:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleCategory"
    // InternalScml.g:353:1: entryRuleCategory returns [EObject current=null] : iv_ruleCategory= ruleCategory EOF ;
    public final EObject entryRuleCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategory = null;


        try {
            // InternalScml.g:353:49: (iv_ruleCategory= ruleCategory EOF )
            // InternalScml.g:354:2: iv_ruleCategory= ruleCategory EOF
            {
             newCompositeNode(grammarAccess.getCategoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategory=ruleCategory();

            state._fsp--;

             current =iv_ruleCategory; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCategory"


    // $ANTLR start "ruleCategory"
    // InternalScml.g:360:1: ruleCategory returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= '(' otherlv_2= 'SDG' otherlv_3= '=' ( (lv_SDG_4_0= ruleEInt ) ) (otherlv_5= ',' ( (lv_SDG_6_0= ruleEInt ) ) )* otherlv_7= ')' )? ) ;
    public final EObject ruleCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_SDG_4_0 = null;

        AntlrDatatypeRuleToken lv_SDG_6_0 = null;



        	enterRule();

        try {
            // InternalScml.g:366:2: ( ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= '(' otherlv_2= 'SDG' otherlv_3= '=' ( (lv_SDG_4_0= ruleEInt ) ) (otherlv_5= ',' ( (lv_SDG_6_0= ruleEInt ) ) )* otherlv_7= ')' )? ) )
            // InternalScml.g:367:2: ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= '(' otherlv_2= 'SDG' otherlv_3= '=' ( (lv_SDG_4_0= ruleEInt ) ) (otherlv_5= ',' ( (lv_SDG_6_0= ruleEInt ) ) )* otherlv_7= ')' )? )
            {
            // InternalScml.g:367:2: ( ( (lv_name_0_0= ruleEString ) ) (otherlv_1= '(' otherlv_2= 'SDG' otherlv_3= '=' ( (lv_SDG_4_0= ruleEInt ) ) (otherlv_5= ',' ( (lv_SDG_6_0= ruleEInt ) ) )* otherlv_7= ')' )? )
            // InternalScml.g:368:3: ( (lv_name_0_0= ruleEString ) ) (otherlv_1= '(' otherlv_2= 'SDG' otherlv_3= '=' ( (lv_SDG_4_0= ruleEInt ) ) (otherlv_5= ',' ( (lv_SDG_6_0= ruleEInt ) ) )* otherlv_7= ')' )?
            {
            // InternalScml.g:368:3: ( (lv_name_0_0= ruleEString ) )
            // InternalScml.g:369:4: (lv_name_0_0= ruleEString )
            {
            // InternalScml.g:369:4: (lv_name_0_0= ruleEString )
            // InternalScml.g:370:5: lv_name_0_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getCategoryAccess().getNameEStringParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_11);
            lv_name_0_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCategoryRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalScml.g:387:3: (otherlv_1= '(' otherlv_2= 'SDG' otherlv_3= '=' ( (lv_SDG_4_0= ruleEInt ) ) (otherlv_5= ',' ( (lv_SDG_6_0= ruleEInt ) ) )* otherlv_7= ')' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalScml.g:388:4: otherlv_1= '(' otherlv_2= 'SDG' otherlv_3= '=' ( (lv_SDG_4_0= ruleEInt ) ) (otherlv_5= ',' ( (lv_SDG_6_0= ruleEInt ) ) )* otherlv_7= ')'
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_12); 

                    				newLeafNode(otherlv_1, grammarAccess.getCategoryAccess().getLeftParenthesisKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,20,FOLLOW_13); 

                    				newLeafNode(otherlv_2, grammarAccess.getCategoryAccess().getSDGKeyword_1_1());
                    			
                    otherlv_3=(Token)match(input,21,FOLLOW_14); 

                    				newLeafNode(otherlv_3, grammarAccess.getCategoryAccess().getEqualsSignKeyword_1_2());
                    			
                    // InternalScml.g:400:4: ( (lv_SDG_4_0= ruleEInt ) )
                    // InternalScml.g:401:5: (lv_SDG_4_0= ruleEInt )
                    {
                    // InternalScml.g:401:5: (lv_SDG_4_0= ruleEInt )
                    // InternalScml.g:402:6: lv_SDG_4_0= ruleEInt
                    {

                    						newCompositeNode(grammarAccess.getCategoryAccess().getSDGEIntParserRuleCall_1_3_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_SDG_4_0=ruleEInt();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCategoryRule());
                    						}
                    						add(
                    							current,
                    							"SDG",
                    							lv_SDG_4_0,
                    							"ac.at.tuwien.big.Scml.EInt");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalScml.g:419:4: (otherlv_5= ',' ( (lv_SDG_6_0= ruleEInt ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==15) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalScml.g:420:5: otherlv_5= ',' ( (lv_SDG_6_0= ruleEInt ) )
                    	    {
                    	    otherlv_5=(Token)match(input,15,FOLLOW_14); 

                    	    					newLeafNode(otherlv_5, grammarAccess.getCategoryAccess().getCommaKeyword_1_4_0());
                    	    				
                    	    // InternalScml.g:424:5: ( (lv_SDG_6_0= ruleEInt ) )
                    	    // InternalScml.g:425:6: (lv_SDG_6_0= ruleEInt )
                    	    {
                    	    // InternalScml.g:425:6: (lv_SDG_6_0= ruleEInt )
                    	    // InternalScml.g:426:7: lv_SDG_6_0= ruleEInt
                    	    {

                    	    							newCompositeNode(grammarAccess.getCategoryAccess().getSDGEIntParserRuleCall_1_4_1_0());
                    	    						
                    	    pushFollow(FOLLOW_15);
                    	    lv_SDG_6_0=ruleEInt();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCategoryRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"SDG",
                    	    								lv_SDG_6_0,
                    	    								"ac.at.tuwien.big.Scml.EInt");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,22,FOLLOW_2); 

                    				newLeafNode(otherlv_7, grammarAccess.getCategoryAccess().getRightParenthesisKeyword_1_5());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCategory"


    // $ANTLR start "entryRuleProject"
    // InternalScml.g:453:1: entryRuleProject returns [EObject current=null] : iv_ruleProject= ruleProject EOF ;
    public final EObject entryRuleProject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProject = null;


        try {
            // InternalScml.g:453:48: (iv_ruleProject= ruleProject EOF )
            // InternalScml.g:454:2: iv_ruleProject= ruleProject EOF
            {
             newCompositeNode(grammarAccess.getProjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleProject=ruleProject();

            state._fsp--;

             current =iv_ruleProject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProject"


    // $ANTLR start "ruleProject"
    // InternalScml.g:460:1: ruleProject returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleProject() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_component_11_0 = null;

        EObject lv_component_13_0 = null;

        EObject lv_indicator_17_0 = null;

        EObject lv_indicator_19_0 = null;



        	enterRule();

        try {
            // InternalScml.g:466:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+ {...}?) ) ) )
            // InternalScml.g:467:2: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+ {...}?) ) )
            {
            // InternalScml.g:467:2: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+ {...}?) ) )
            // InternalScml.g:468:3: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+ {...}?) )
            {
            // InternalScml.g:468:3: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+ {...}?) )
            // InternalScml.g:469:4: ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getProjectAccess().getUnorderedGroup());
            			
            // InternalScml.g:472:4: ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+ {...}?)
            // InternalScml.g:473:5: ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+ {...}?
            {
            // InternalScml.g:473:5: ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( LA16_0 >= RULE_STRING && LA16_0 <= RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectAccess().getUnorderedGroup(), 0) ) {
                    alt16=1;
                }
                else if ( ( LA16_0 == 18 || LA16_0 == 25 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getProjectAccess().getUnorderedGroup(), 1) ) {
                    alt16=2;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalScml.g:474:3: ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) )
            	    {
            	    // InternalScml.g:474:3: ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) ) )
            	    // InternalScml.g:475:4: {...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleProject", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalScml.g:475:101: ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) ) )
            	    // InternalScml.g:476:5: ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalScml.g:479:8: ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? ) )
            	    // InternalScml.g:479:9: {...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProject", "true");
            	    }
            	    // InternalScml.g:479:18: ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )? )
            	    // InternalScml.g:479:19: ( (lv_name_1_0= ruleEString ) ) (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? otherlv_8= '{' (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )?
            	    {
            	    // InternalScml.g:479:19: ( (lv_name_1_0= ruleEString ) )
            	    // InternalScml.g:480:9: (lv_name_1_0= ruleEString )
            	    {
            	    // InternalScml.g:480:9: (lv_name_1_0= ruleEString )
            	    // InternalScml.g:481:10: lv_name_1_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getProjectAccess().getNameEStringParserRuleCall_0_0_0());
            	    									
            	    pushFollow(FOLLOW_16);
            	    lv_name_1_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getProjectRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_1_0,
            	    											"ac.at.tuwien.big.Scml.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalScml.g:498:8: (otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )?
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==23) ) {
            	        alt11=1;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // InternalScml.g:499:9: otherlv_2= 'belongsTo' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')'
            	            {
            	            otherlv_2=(Token)match(input,23,FOLLOW_17); 

            	            									newLeafNode(otherlv_2, grammarAccess.getProjectAccess().getBelongsToKeyword_0_1_0());
            	            								
            	            otherlv_3=(Token)match(input,19,FOLLOW_18); 

            	            									newLeafNode(otherlv_3, grammarAccess.getProjectAccess().getLeftParenthesisKeyword_0_1_1());
            	            								
            	            // InternalScml.g:507:9: ( (otherlv_4= RULE_ID ) )
            	            // InternalScml.g:508:10: (otherlv_4= RULE_ID )
            	            {
            	            // InternalScml.g:508:10: (otherlv_4= RULE_ID )
            	            // InternalScml.g:509:11: otherlv_4= RULE_ID
            	            {

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getProjectRule());
            	            											}
            	            										
            	            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_15); 

            	            											newLeafNode(otherlv_4, grammarAccess.getProjectAccess().getCategoryCategoryCrossReference_0_1_2_0());
            	            										

            	            }


            	            }

            	            // InternalScml.g:520:9: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            	            loop10:
            	            do {
            	                int alt10=2;
            	                int LA10_0 = input.LA(1);

            	                if ( (LA10_0==15) ) {
            	                    alt10=1;
            	                }


            	                switch (alt10) {
            	            	case 1 :
            	            	    // InternalScml.g:521:10: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	            	    {
            	            	    otherlv_5=(Token)match(input,15,FOLLOW_18); 

            	            	    										newLeafNode(otherlv_5, grammarAccess.getProjectAccess().getCommaKeyword_0_1_3_0());
            	            	    									
            	            	    // InternalScml.g:525:10: ( (otherlv_6= RULE_ID ) )
            	            	    // InternalScml.g:526:11: (otherlv_6= RULE_ID )
            	            	    {
            	            	    // InternalScml.g:526:11: (otherlv_6= RULE_ID )
            	            	    // InternalScml.g:527:12: otherlv_6= RULE_ID
            	            	    {

            	            	    												if (current==null) {
            	            	    													current = createModelElement(grammarAccess.getProjectRule());
            	            	    												}
            	            	    											
            	            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_15); 

            	            	    												newLeafNode(otherlv_6, grammarAccess.getProjectAccess().getCategoryCategoryCrossReference_0_1_3_1_0());
            	            	    											

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop10;
            	                }
            	            } while (true);

            	            otherlv_7=(Token)match(input,22,FOLLOW_4); 

            	            									newLeafNode(otherlv_7, grammarAccess.getProjectAccess().getRightParenthesisKeyword_0_1_4());
            	            								

            	            }
            	            break;

            	    }

            	    otherlv_8=(Token)match(input,12,FOLLOW_19); 

            	    								newLeafNode(otherlv_8, grammarAccess.getProjectAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalScml.g:548:8: (otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']' )?
            	    int alt13=2;
            	    int LA13_0 = input.LA(1);

            	    if ( (LA13_0==24) ) {
            	        alt13=1;
            	    }
            	    switch (alt13) {
            	        case 1 :
            	            // InternalScml.g:549:9: otherlv_9= 'components' otherlv_10= '[' ( (lv_component_11_0= ruleInfrastructureComponent ) ) (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )* otherlv_14= ']'
            	            {
            	            otherlv_9=(Token)match(input,24,FOLLOW_6); 

            	            									newLeafNode(otherlv_9, grammarAccess.getProjectAccess().getComponentsKeyword_0_3_0());
            	            								
            	            otherlv_10=(Token)match(input,14,FOLLOW_20); 

            	            									newLeafNode(otherlv_10, grammarAccess.getProjectAccess().getLeftSquareBracketKeyword_0_3_1());
            	            								
            	            // InternalScml.g:557:9: ( (lv_component_11_0= ruleInfrastructureComponent ) )
            	            // InternalScml.g:558:10: (lv_component_11_0= ruleInfrastructureComponent )
            	            {
            	            // InternalScml.g:558:10: (lv_component_11_0= ruleInfrastructureComponent )
            	            // InternalScml.g:559:11: lv_component_11_0= ruleInfrastructureComponent
            	            {

            	            											newCompositeNode(grammarAccess.getProjectAccess().getComponentInfrastructureComponentParserRuleCall_0_3_2_0());
            	            										
            	            pushFollow(FOLLOW_7);
            	            lv_component_11_0=ruleInfrastructureComponent();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getProjectRule());
            	            											}
            	            											add(
            	            												current,
            	            												"component",
            	            												lv_component_11_0,
            	            												"ac.at.tuwien.big.Scml.InfrastructureComponent");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }

            	            // InternalScml.g:576:9: (otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) ) )*
            	            loop12:
            	            do {
            	                int alt12=2;
            	                int LA12_0 = input.LA(1);

            	                if ( (LA12_0==15) ) {
            	                    alt12=1;
            	                }


            	                switch (alt12) {
            	            	case 1 :
            	            	    // InternalScml.g:577:10: otherlv_12= ',' ( (lv_component_13_0= ruleInfrastructureComponent ) )
            	            	    {
            	            	    otherlv_12=(Token)match(input,15,FOLLOW_20); 

            	            	    										newLeafNode(otherlv_12, grammarAccess.getProjectAccess().getCommaKeyword_0_3_3_0());
            	            	    									
            	            	    // InternalScml.g:581:10: ( (lv_component_13_0= ruleInfrastructureComponent ) )
            	            	    // InternalScml.g:582:11: (lv_component_13_0= ruleInfrastructureComponent )
            	            	    {
            	            	    // InternalScml.g:582:11: (lv_component_13_0= ruleInfrastructureComponent )
            	            	    // InternalScml.g:583:12: lv_component_13_0= ruleInfrastructureComponent
            	            	    {

            	            	    												newCompositeNode(grammarAccess.getProjectAccess().getComponentInfrastructureComponentParserRuleCall_0_3_3_1_0());
            	            	    											
            	            	    pushFollow(FOLLOW_7);
            	            	    lv_component_13_0=ruleInfrastructureComponent();

            	            	    state._fsp--;


            	            	    												if (current==null) {
            	            	    													current = createModelElementForParent(grammarAccess.getProjectRule());
            	            	    												}
            	            	    												add(
            	            	    													current,
            	            	    													"component",
            	            	    													lv_component_13_0,
            	            	    													"ac.at.tuwien.big.Scml.InfrastructureComponent");
            	            	    												afterParserOrEnumRuleCall();
            	            	    											

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop12;
            	                }
            	            } while (true);

            	            otherlv_14=(Token)match(input,16,FOLLOW_21); 

            	            									newLeafNode(otherlv_14, grammarAccess.getProjectAccess().getRightSquareBracketKeyword_0_3_4());
            	            								

            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalScml.g:612:3: ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) )
            	    {
            	    // InternalScml.g:612:3: ({...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) ) )
            	    // InternalScml.g:613:4: {...}? => ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getProjectAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleProject", "getUnorderedGroupHelper().canSelect(grammarAccess.getProjectAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalScml.g:613:101: ( ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) ) )
            	    // InternalScml.g:614:5: ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getProjectAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalScml.g:617:8: ({...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' ) )
            	    // InternalScml.g:617:9: {...}? => ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleProject", "true");
            	    }
            	    // InternalScml.g:617:18: ( (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}' )
            	    // InternalScml.g:617:19: (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )? otherlv_21= '}'
            	    {
            	    // InternalScml.g:617:19: (otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']' )?
            	    int alt15=2;
            	    int LA15_0 = input.LA(1);

            	    if ( (LA15_0==25) ) {
            	        alt15=1;
            	    }
            	    switch (alt15) {
            	        case 1 :
            	            // InternalScml.g:618:9: otherlv_15= 'indicators' otherlv_16= '[' ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) ) (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )* otherlv_20= ']'
            	            {
            	            otherlv_15=(Token)match(input,25,FOLLOW_6); 

            	            									newLeafNode(otherlv_15, grammarAccess.getProjectAccess().getIndicatorsKeyword_1_0_0());
            	            								
            	            otherlv_16=(Token)match(input,14,FOLLOW_22); 

            	            									newLeafNode(otherlv_16, grammarAccess.getProjectAccess().getLeftSquareBracketKeyword_1_0_1());
            	            								
            	            // InternalScml.g:626:9: ( (lv_indicator_17_0= ruleKPIMeasurementDevice ) )
            	            // InternalScml.g:627:10: (lv_indicator_17_0= ruleKPIMeasurementDevice )
            	            {
            	            // InternalScml.g:627:10: (lv_indicator_17_0= ruleKPIMeasurementDevice )
            	            // InternalScml.g:628:11: lv_indicator_17_0= ruleKPIMeasurementDevice
            	            {

            	            											newCompositeNode(grammarAccess.getProjectAccess().getIndicatorKPIMeasurementDeviceParserRuleCall_1_0_2_0());
            	            										
            	            pushFollow(FOLLOW_7);
            	            lv_indicator_17_0=ruleKPIMeasurementDevice();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getProjectRule());
            	            											}
            	            											add(
            	            												current,
            	            												"indicator",
            	            												lv_indicator_17_0,
            	            												"ac.at.tuwien.big.Scml.KPIMeasurementDevice");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }

            	            // InternalScml.g:645:9: (otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) ) )*
            	            loop14:
            	            do {
            	                int alt14=2;
            	                int LA14_0 = input.LA(1);

            	                if ( (LA14_0==15) ) {
            	                    alt14=1;
            	                }


            	                switch (alt14) {
            	            	case 1 :
            	            	    // InternalScml.g:646:10: otherlv_18= ',' ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) )
            	            	    {
            	            	    otherlv_18=(Token)match(input,15,FOLLOW_22); 

            	            	    										newLeafNode(otherlv_18, grammarAccess.getProjectAccess().getCommaKeyword_1_0_3_0());
            	            	    									
            	            	    // InternalScml.g:650:10: ( (lv_indicator_19_0= ruleKPIMeasurementDevice ) )
            	            	    // InternalScml.g:651:11: (lv_indicator_19_0= ruleKPIMeasurementDevice )
            	            	    {
            	            	    // InternalScml.g:651:11: (lv_indicator_19_0= ruleKPIMeasurementDevice )
            	            	    // InternalScml.g:652:12: lv_indicator_19_0= ruleKPIMeasurementDevice
            	            	    {

            	            	    												newCompositeNode(grammarAccess.getProjectAccess().getIndicatorKPIMeasurementDeviceParserRuleCall_1_0_3_1_0());
            	            	    											
            	            	    pushFollow(FOLLOW_7);
            	            	    lv_indicator_19_0=ruleKPIMeasurementDevice();

            	            	    state._fsp--;


            	            	    												if (current==null) {
            	            	    													current = createModelElementForParent(grammarAccess.getProjectRule());
            	            	    												}
            	            	    												add(
            	            	    													current,
            	            	    													"indicator",
            	            	    													lv_indicator_19_0,
            	            	    													"ac.at.tuwien.big.Scml.KPIMeasurementDevice");
            	            	    												afterParserOrEnumRuleCall();
            	            	    											

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop14;
            	                }
            	            } while (true);

            	            otherlv_20=(Token)match(input,16,FOLLOW_10); 

            	            									newLeafNode(otherlv_20, grammarAccess.getProjectAccess().getRightSquareBracketKeyword_1_0_4());
            	            								

            	            }
            	            break;

            	    }

            	    otherlv_21=(Token)match(input,18,FOLLOW_21); 

            	    								newLeafNode(otherlv_21, grammarAccess.getProjectAccess().getRightCurlyBracketKeyword_1_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getProjectAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getProjectAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleProject", "getUnorderedGroupHelper().canLeave(grammarAccess.getProjectAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getProjectAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProject"


    // $ANTLR start "entryRuleEInt"
    // InternalScml.g:696:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // InternalScml.g:696:44: (iv_ruleEInt= ruleEInt EOF )
            // InternalScml.g:697:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalScml.g:703:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;


        	enterRule();

        try {
            // InternalScml.g:709:2: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // InternalScml.g:710:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // InternalScml.g:710:2: ( (kw= '-' )? this_INT_1= RULE_INT )
            // InternalScml.g:711:3: (kw= '-' )? this_INT_1= RULE_INT
            {
            // InternalScml.g:711:3: (kw= '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalScml.g:712:4: kw= '-'
                    {
                    kw=(Token)match(input,26,FOLLOW_23); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleKPIMeasurementDevice"
    // InternalScml.g:729:1: entryRuleKPIMeasurementDevice returns [EObject current=null] : iv_ruleKPIMeasurementDevice= ruleKPIMeasurementDevice EOF ;
    public final EObject entryRuleKPIMeasurementDevice() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKPIMeasurementDevice = null;


        try {
            // InternalScml.g:729:61: (iv_ruleKPIMeasurementDevice= ruleKPIMeasurementDevice EOF )
            // InternalScml.g:730:2: iv_ruleKPIMeasurementDevice= ruleKPIMeasurementDevice EOF
            {
             newCompositeNode(grammarAccess.getKPIMeasurementDeviceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKPIMeasurementDevice=ruleKPIMeasurementDevice();

            state._fsp--;

             current =iv_ruleKPIMeasurementDevice; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleKPIMeasurementDevice"


    // $ANTLR start "ruleKPIMeasurementDevice"
    // InternalScml.g:736:1: ruleKPIMeasurementDevice returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleKPIMeasurementDevice() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_status_5_0 = null;

        AntlrDatatypeRuleToken lv_lastCalculation_14_0 = null;

        AntlrDatatypeRuleToken lv_lastCalculation_16_0 = null;

        AntlrDatatypeRuleToken lv_nextCalculation_19_0 = null;



        	enterRule();

        try {
            // InternalScml.g:742:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+ {...}?) ) ) )
            // InternalScml.g:743:2: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+ {...}?) ) )
            {
            // InternalScml.g:743:2: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+ {...}?) ) )
            // InternalScml.g:744:3: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+ {...}?) )
            {
            // InternalScml.g:744:3: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+ {...}?) )
            // InternalScml.g:745:4: ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup());
            			
            // InternalScml.g:748:4: ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+ {...}?)
            // InternalScml.g:749:5: ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+ {...}?
            {
            // InternalScml.g:749:5: ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( LA22_0 >= RULE_STRING && LA22_0 <= RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup(), 0) ) {
                    alt22=1;
                }
                else if ( LA22_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup(), 1) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalScml.g:750:3: ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) )
            	    {
            	    // InternalScml.g:750:3: ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) ) )
            	    // InternalScml.g:751:4: {...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleKPIMeasurementDevice", "getUnorderedGroupHelper().canSelect(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalScml.g:751:114: ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) ) )
            	    // InternalScml.g:752:5: ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalScml.g:755:8: ({...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? ) )
            	    // InternalScml.g:755:9: {...}? => ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleKPIMeasurementDevice", "true");
            	    }
            	    // InternalScml.g:755:18: ( ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )? )
            	    // InternalScml.g:755:19: ( (lv_name_1_0= ruleEString ) ) (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )? otherlv_11= '{' (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )?
            	    {
            	    // InternalScml.g:755:19: ( (lv_name_1_0= ruleEString ) )
            	    // InternalScml.g:756:9: (lv_name_1_0= ruleEString )
            	    {
            	    // InternalScml.g:756:9: (lv_name_1_0= ruleEString )
            	    // InternalScml.g:757:10: lv_name_1_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getKPIMeasurementDeviceAccess().getNameEStringParserRuleCall_0_0_0());
            	    									
            	    pushFollow(FOLLOW_24);
            	    lv_name_1_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getKPIMeasurementDeviceRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_1_0,
            	    											"ac.at.tuwien.big.Scml.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalScml.g:774:8: (otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')' )?
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==19) ) {
            	        alt19=1;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // InternalScml.g:775:9: otherlv_2= '(' otherlv_3= 'status' otherlv_4= '=' ( (lv_status_5_0= ruleStatus ) ) (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )? otherlv_10= ')'
            	            {
            	            otherlv_2=(Token)match(input,19,FOLLOW_25); 

            	            									newLeafNode(otherlv_2, grammarAccess.getKPIMeasurementDeviceAccess().getLeftParenthesisKeyword_0_1_0());
            	            								
            	            otherlv_3=(Token)match(input,27,FOLLOW_13); 

            	            									newLeafNode(otherlv_3, grammarAccess.getKPIMeasurementDeviceAccess().getStatusKeyword_0_1_1());
            	            								
            	            otherlv_4=(Token)match(input,21,FOLLOW_26); 

            	            									newLeafNode(otherlv_4, grammarAccess.getKPIMeasurementDeviceAccess().getEqualsSignKeyword_0_1_2());
            	            								
            	            // InternalScml.g:787:9: ( (lv_status_5_0= ruleStatus ) )
            	            // InternalScml.g:788:10: (lv_status_5_0= ruleStatus )
            	            {
            	            // InternalScml.g:788:10: (lv_status_5_0= ruleStatus )
            	            // InternalScml.g:789:11: lv_status_5_0= ruleStatus
            	            {

            	            											newCompositeNode(grammarAccess.getKPIMeasurementDeviceAccess().getStatusStatusEnumRuleCall_0_1_3_0());
            	            										
            	            pushFollow(FOLLOW_15);
            	            lv_status_5_0=ruleStatus();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getKPIMeasurementDeviceRule());
            	            											}
            	            											set(
            	            												current,
            	            												"status",
            	            												lv_status_5_0,
            	            												"ac.at.tuwien.big.Scml.Status");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }

            	            // InternalScml.g:806:9: (otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) ) )?
            	            int alt18=2;
            	            int LA18_0 = input.LA(1);

            	            if ( (LA18_0==15) ) {
            	                alt18=1;
            	            }
            	            switch (alt18) {
            	                case 1 :
            	                    // InternalScml.g:807:10: otherlv_6= ',' otherlv_7= 'parameter' otherlv_8= '=' ( (otherlv_9= RULE_ID ) )
            	                    {
            	                    otherlv_6=(Token)match(input,15,FOLLOW_27); 

            	                    										newLeafNode(otherlv_6, grammarAccess.getKPIMeasurementDeviceAccess().getCommaKeyword_0_1_4_0());
            	                    									
            	                    otherlv_7=(Token)match(input,28,FOLLOW_13); 

            	                    										newLeafNode(otherlv_7, grammarAccess.getKPIMeasurementDeviceAccess().getParameterKeyword_0_1_4_1());
            	                    									
            	                    otherlv_8=(Token)match(input,21,FOLLOW_18); 

            	                    										newLeafNode(otherlv_8, grammarAccess.getKPIMeasurementDeviceAccess().getEqualsSignKeyword_0_1_4_2());
            	                    									
            	                    // InternalScml.g:819:10: ( (otherlv_9= RULE_ID ) )
            	                    // InternalScml.g:820:11: (otherlv_9= RULE_ID )
            	                    {
            	                    // InternalScml.g:820:11: (otherlv_9= RULE_ID )
            	                    // InternalScml.g:821:12: otherlv_9= RULE_ID
            	                    {

            	                    												if (current==null) {
            	                    													current = createModelElement(grammarAccess.getKPIMeasurementDeviceRule());
            	                    												}
            	                    											
            	                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_28); 

            	                    												newLeafNode(otherlv_9, grammarAccess.getKPIMeasurementDeviceAccess().getParameterParameterCrossReference_0_1_4_3_0());
            	                    											

            	                    }


            	                    }


            	                    }
            	                    break;

            	            }

            	            otherlv_10=(Token)match(input,22,FOLLOW_4); 

            	            									newLeafNode(otherlv_10, grammarAccess.getKPIMeasurementDeviceAccess().getRightParenthesisKeyword_0_1_5());
            	            								

            	            }
            	            break;

            	    }

            	    otherlv_11=(Token)match(input,12,FOLLOW_29); 

            	    								newLeafNode(otherlv_11, grammarAccess.getKPIMeasurementDeviceAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalScml.g:842:8: (otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']' )?
            	    int alt21=2;
            	    int LA21_0 = input.LA(1);

            	    if ( (LA21_0==29) ) {
            	        alt21=1;
            	    }
            	    switch (alt21) {
            	        case 1 :
            	            // InternalScml.g:843:9: otherlv_12= 'lastCalculation' otherlv_13= '[' ( (lv_lastCalculation_14_0= ruleEString ) ) (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )* otherlv_17= ']'
            	            {
            	            otherlv_12=(Token)match(input,29,FOLLOW_6); 

            	            									newLeafNode(otherlv_12, grammarAccess.getKPIMeasurementDeviceAccess().getLastCalculationKeyword_0_3_0());
            	            								
            	            otherlv_13=(Token)match(input,14,FOLLOW_3); 

            	            									newLeafNode(otherlv_13, grammarAccess.getKPIMeasurementDeviceAccess().getLeftSquareBracketKeyword_0_3_1());
            	            								
            	            // InternalScml.g:851:9: ( (lv_lastCalculation_14_0= ruleEString ) )
            	            // InternalScml.g:852:10: (lv_lastCalculation_14_0= ruleEString )
            	            {
            	            // InternalScml.g:852:10: (lv_lastCalculation_14_0= ruleEString )
            	            // InternalScml.g:853:11: lv_lastCalculation_14_0= ruleEString
            	            {

            	            											newCompositeNode(grammarAccess.getKPIMeasurementDeviceAccess().getLastCalculationEStringParserRuleCall_0_3_2_0());
            	            										
            	            pushFollow(FOLLOW_7);
            	            lv_lastCalculation_14_0=ruleEString();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getKPIMeasurementDeviceRule());
            	            											}
            	            											add(
            	            												current,
            	            												"lastCalculation",
            	            												lv_lastCalculation_14_0,
            	            												"ac.at.tuwien.big.Scml.EString");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }

            	            // InternalScml.g:870:9: (otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) ) )*
            	            loop20:
            	            do {
            	                int alt20=2;
            	                int LA20_0 = input.LA(1);

            	                if ( (LA20_0==15) ) {
            	                    alt20=1;
            	                }


            	                switch (alt20) {
            	            	case 1 :
            	            	    // InternalScml.g:871:10: otherlv_15= ',' ( (lv_lastCalculation_16_0= ruleEString ) )
            	            	    {
            	            	    otherlv_15=(Token)match(input,15,FOLLOW_3); 

            	            	    										newLeafNode(otherlv_15, grammarAccess.getKPIMeasurementDeviceAccess().getCommaKeyword_0_3_3_0());
            	            	    									
            	            	    // InternalScml.g:875:10: ( (lv_lastCalculation_16_0= ruleEString ) )
            	            	    // InternalScml.g:876:11: (lv_lastCalculation_16_0= ruleEString )
            	            	    {
            	            	    // InternalScml.g:876:11: (lv_lastCalculation_16_0= ruleEString )
            	            	    // InternalScml.g:877:12: lv_lastCalculation_16_0= ruleEString
            	            	    {

            	            	    												newCompositeNode(grammarAccess.getKPIMeasurementDeviceAccess().getLastCalculationEStringParserRuleCall_0_3_3_1_0());
            	            	    											
            	            	    pushFollow(FOLLOW_7);
            	            	    lv_lastCalculation_16_0=ruleEString();

            	            	    state._fsp--;


            	            	    												if (current==null) {
            	            	    													current = createModelElementForParent(grammarAccess.getKPIMeasurementDeviceRule());
            	            	    												}
            	            	    												add(
            	            	    													current,
            	            	    													"lastCalculation",
            	            	    													lv_lastCalculation_16_0,
            	            	    													"ac.at.tuwien.big.Scml.EString");
            	            	    												afterParserOrEnumRuleCall();
            	            	    											

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop20;
            	                }
            	            } while (true);

            	            otherlv_17=(Token)match(input,16,FOLLOW_30); 

            	            									newLeafNode(otherlv_17, grammarAccess.getKPIMeasurementDeviceAccess().getRightSquareBracketKeyword_0_3_4());
            	            								

            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalScml.g:906:3: ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) )
            	    {
            	    // InternalScml.g:906:3: ({...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) ) )
            	    // InternalScml.g:907:4: {...}? => ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleKPIMeasurementDevice", "getUnorderedGroupHelper().canSelect(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalScml.g:907:114: ( ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) ) )
            	    // InternalScml.g:908:5: ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalScml.g:911:8: ({...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' ) )
            	    // InternalScml.g:911:9: {...}? => (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleKPIMeasurementDevice", "true");
            	    }
            	    // InternalScml.g:911:18: (otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}' )
            	    // InternalScml.g:911:19: otherlv_18= 'nextCalculation' ( (lv_nextCalculation_19_0= ruleEString ) ) otherlv_20= '}'
            	    {
            	    otherlv_18=(Token)match(input,30,FOLLOW_3); 

            	    								newLeafNode(otherlv_18, grammarAccess.getKPIMeasurementDeviceAccess().getNextCalculationKeyword_1_0());
            	    							
            	    // InternalScml.g:915:8: ( (lv_nextCalculation_19_0= ruleEString ) )
            	    // InternalScml.g:916:9: (lv_nextCalculation_19_0= ruleEString )
            	    {
            	    // InternalScml.g:916:9: (lv_nextCalculation_19_0= ruleEString )
            	    // InternalScml.g:917:10: lv_nextCalculation_19_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getKPIMeasurementDeviceAccess().getNextCalculationEStringParserRuleCall_1_1_0());
            	    									
            	    pushFollow(FOLLOW_10);
            	    lv_nextCalculation_19_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getKPIMeasurementDeviceRule());
            	    										}
            	    										set(
            	    											current,
            	    											"nextCalculation",
            	    											lv_nextCalculation_19_0,
            	    											"ac.at.tuwien.big.Scml.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    otherlv_20=(Token)match(input,18,FOLLOW_30); 

            	    								newLeafNode(otherlv_20, grammarAccess.getKPIMeasurementDeviceAccess().getRightCurlyBracketKeyword_1_2());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleKPIMeasurementDevice", "getUnorderedGroupHelper().canLeave(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getKPIMeasurementDeviceAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleKPIMeasurementDevice"


    // $ANTLR start "entryRuleLocation"
    // InternalScml.g:955:1: entryRuleLocation returns [EObject current=null] : iv_ruleLocation= ruleLocation EOF ;
    public final EObject entryRuleLocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocation = null;


        try {
            // InternalScml.g:955:49: (iv_ruleLocation= ruleLocation EOF )
            // InternalScml.g:956:2: iv_ruleLocation= ruleLocation EOF
            {
             newCompositeNode(grammarAccess.getLocationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocation=ruleLocation();

            state._fsp--;

             current =iv_ruleLocation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocation"


    // $ANTLR start "ruleLocation"
    // InternalScml.g:962:1: ruleLocation returns [EObject current=null] : (otherlv_0= 'lat' otherlv_1= '=' ( (lv_Lat_2_0= ruleEFloat ) ) otherlv_3= ',' otherlv_4= 'long' otherlv_5= '=' ( (lv_Long_6_0= ruleEFloat ) ) ) ;
    public final EObject ruleLocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_Lat_2_0 = null;

        AntlrDatatypeRuleToken lv_Long_6_0 = null;



        	enterRule();

        try {
            // InternalScml.g:968:2: ( (otherlv_0= 'lat' otherlv_1= '=' ( (lv_Lat_2_0= ruleEFloat ) ) otherlv_3= ',' otherlv_4= 'long' otherlv_5= '=' ( (lv_Long_6_0= ruleEFloat ) ) ) )
            // InternalScml.g:969:2: (otherlv_0= 'lat' otherlv_1= '=' ( (lv_Lat_2_0= ruleEFloat ) ) otherlv_3= ',' otherlv_4= 'long' otherlv_5= '=' ( (lv_Long_6_0= ruleEFloat ) ) )
            {
            // InternalScml.g:969:2: (otherlv_0= 'lat' otherlv_1= '=' ( (lv_Lat_2_0= ruleEFloat ) ) otherlv_3= ',' otherlv_4= 'long' otherlv_5= '=' ( (lv_Long_6_0= ruleEFloat ) ) )
            // InternalScml.g:970:3: otherlv_0= 'lat' otherlv_1= '=' ( (lv_Lat_2_0= ruleEFloat ) ) otherlv_3= ',' otherlv_4= 'long' otherlv_5= '=' ( (lv_Long_6_0= ruleEFloat ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_13); 

            			newLeafNode(otherlv_0, grammarAccess.getLocationAccess().getLatKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getLocationAccess().getEqualsSignKeyword_1());
            		
            // InternalScml.g:978:3: ( (lv_Lat_2_0= ruleEFloat ) )
            // InternalScml.g:979:4: (lv_Lat_2_0= ruleEFloat )
            {
            // InternalScml.g:979:4: (lv_Lat_2_0= ruleEFloat )
            // InternalScml.g:980:5: lv_Lat_2_0= ruleEFloat
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getLatEFloatParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_32);
            lv_Lat_2_0=ruleEFloat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					set(
            						current,
            						"Lat",
            						lv_Lat_2_0,
            						"ac.at.tuwien.big.Scml.EFloat");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_33); 

            			newLeafNode(otherlv_3, grammarAccess.getLocationAccess().getCommaKeyword_3());
            		
            otherlv_4=(Token)match(input,32,FOLLOW_13); 

            			newLeafNode(otherlv_4, grammarAccess.getLocationAccess().getLongKeyword_4());
            		
            otherlv_5=(Token)match(input,21,FOLLOW_31); 

            			newLeafNode(otherlv_5, grammarAccess.getLocationAccess().getEqualsSignKeyword_5());
            		
            // InternalScml.g:1009:3: ( (lv_Long_6_0= ruleEFloat ) )
            // InternalScml.g:1010:4: (lv_Long_6_0= ruleEFloat )
            {
            // InternalScml.g:1010:4: (lv_Long_6_0= ruleEFloat )
            // InternalScml.g:1011:5: lv_Long_6_0= ruleEFloat
            {

            					newCompositeNode(grammarAccess.getLocationAccess().getLongEFloatParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_Long_6_0=ruleEFloat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocationRule());
            					}
            					set(
            						current,
            						"Long",
            						lv_Long_6_0,
            						"ac.at.tuwien.big.Scml.EFloat");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocation"


    // $ANTLR start "entryRuleDataValue"
    // InternalScml.g:1032:1: entryRuleDataValue returns [EObject current=null] : iv_ruleDataValue= ruleDataValue EOF ;
    public final EObject entryRuleDataValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataValue = null;


        try {
            // InternalScml.g:1032:50: (iv_ruleDataValue= ruleDataValue EOF )
            // InternalScml.g:1033:2: iv_ruleDataValue= ruleDataValue EOF
            {
             newCompositeNode(grammarAccess.getDataValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDataValue=ruleDataValue();

            state._fsp--;

             current =iv_ruleDataValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDataValue"


    // $ANTLR start "ruleDataValue"
    // InternalScml.g:1039:1: ruleDataValue returns [EObject current=null] : (otherlv_0= 'DataValue' (otherlv_1= '(' ( (lv_collected_2_0= 'collected' ) ) otherlv_3= ')' )? otherlv_4= '{' otherlv_5= 'dType' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleEString ) ) otherlv_9= 'producedTime' ( (lv_producedTime_10_0= ruleEString ) ) (otherlv_11= 'consumedTime' ( (lv_consumedTime_12_0= ruleEString ) ) )? otherlv_13= '}' ) ;
    public final EObject ruleDataValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_collected_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Enumerator lv_type_6_0 = null;

        AntlrDatatypeRuleToken lv_value_8_0 = null;

        AntlrDatatypeRuleToken lv_producedTime_10_0 = null;

        AntlrDatatypeRuleToken lv_consumedTime_12_0 = null;



        	enterRule();

        try {
            // InternalScml.g:1045:2: ( (otherlv_0= 'DataValue' (otherlv_1= '(' ( (lv_collected_2_0= 'collected' ) ) otherlv_3= ')' )? otherlv_4= '{' otherlv_5= 'dType' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleEString ) ) otherlv_9= 'producedTime' ( (lv_producedTime_10_0= ruleEString ) ) (otherlv_11= 'consumedTime' ( (lv_consumedTime_12_0= ruleEString ) ) )? otherlv_13= '}' ) )
            // InternalScml.g:1046:2: (otherlv_0= 'DataValue' (otherlv_1= '(' ( (lv_collected_2_0= 'collected' ) ) otherlv_3= ')' )? otherlv_4= '{' otherlv_5= 'dType' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleEString ) ) otherlv_9= 'producedTime' ( (lv_producedTime_10_0= ruleEString ) ) (otherlv_11= 'consumedTime' ( (lv_consumedTime_12_0= ruleEString ) ) )? otherlv_13= '}' )
            {
            // InternalScml.g:1046:2: (otherlv_0= 'DataValue' (otherlv_1= '(' ( (lv_collected_2_0= 'collected' ) ) otherlv_3= ')' )? otherlv_4= '{' otherlv_5= 'dType' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleEString ) ) otherlv_9= 'producedTime' ( (lv_producedTime_10_0= ruleEString ) ) (otherlv_11= 'consumedTime' ( (lv_consumedTime_12_0= ruleEString ) ) )? otherlv_13= '}' )
            // InternalScml.g:1047:3: otherlv_0= 'DataValue' (otherlv_1= '(' ( (lv_collected_2_0= 'collected' ) ) otherlv_3= ')' )? otherlv_4= '{' otherlv_5= 'dType' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'value' ( (lv_value_8_0= ruleEString ) ) otherlv_9= 'producedTime' ( (lv_producedTime_10_0= ruleEString ) ) (otherlv_11= 'consumedTime' ( (lv_consumedTime_12_0= ruleEString ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_24); 

            			newLeafNode(otherlv_0, grammarAccess.getDataValueAccess().getDataValueKeyword_0());
            		
            // InternalScml.g:1051:3: (otherlv_1= '(' ( (lv_collected_2_0= 'collected' ) ) otherlv_3= ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==19) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalScml.g:1052:4: otherlv_1= '(' ( (lv_collected_2_0= 'collected' ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_34); 

                    				newLeafNode(otherlv_1, grammarAccess.getDataValueAccess().getLeftParenthesisKeyword_1_0());
                    			
                    // InternalScml.g:1056:4: ( (lv_collected_2_0= 'collected' ) )
                    // InternalScml.g:1057:5: (lv_collected_2_0= 'collected' )
                    {
                    // InternalScml.g:1057:5: (lv_collected_2_0= 'collected' )
                    // InternalScml.g:1058:6: lv_collected_2_0= 'collected'
                    {
                    lv_collected_2_0=(Token)match(input,34,FOLLOW_28); 

                    						newLeafNode(lv_collected_2_0, grammarAccess.getDataValueAccess().getCollectedCollectedKeyword_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDataValueRule());
                    						}
                    						setWithLastConsumed(current, "collected", lv_collected_2_0 != null, "collected");
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,22,FOLLOW_4); 

                    				newLeafNode(otherlv_3, grammarAccess.getDataValueAccess().getRightParenthesisKeyword_1_2());
                    			

                    }
                    break;

            }

            otherlv_4=(Token)match(input,12,FOLLOW_35); 

            			newLeafNode(otherlv_4, grammarAccess.getDataValueAccess().getLeftCurlyBracketKeyword_2());
            		
            otherlv_5=(Token)match(input,35,FOLLOW_36); 

            			newLeafNode(otherlv_5, grammarAccess.getDataValueAccess().getDTypeKeyword_3());
            		
            // InternalScml.g:1083:3: ( (lv_type_6_0= ruleDataType ) )
            // InternalScml.g:1084:4: (lv_type_6_0= ruleDataType )
            {
            // InternalScml.g:1084:4: (lv_type_6_0= ruleDataType )
            // InternalScml.g:1085:5: lv_type_6_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getDataValueAccess().getTypeDataTypeEnumRuleCall_4_0());
            				
            pushFollow(FOLLOW_37);
            lv_type_6_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataValueRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"ac.at.tuwien.big.Scml.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,36,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getDataValueAccess().getValueKeyword_5());
            		
            // InternalScml.g:1106:3: ( (lv_value_8_0= ruleEString ) )
            // InternalScml.g:1107:4: (lv_value_8_0= ruleEString )
            {
            // InternalScml.g:1107:4: (lv_value_8_0= ruleEString )
            // InternalScml.g:1108:5: lv_value_8_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataValueAccess().getValueEStringParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_38);
            lv_value_8_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_8_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_9, grammarAccess.getDataValueAccess().getProducedTimeKeyword_7());
            		
            // InternalScml.g:1129:3: ( (lv_producedTime_10_0= ruleEString ) )
            // InternalScml.g:1130:4: (lv_producedTime_10_0= ruleEString )
            {
            // InternalScml.g:1130:4: (lv_producedTime_10_0= ruleEString )
            // InternalScml.g:1131:5: lv_producedTime_10_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getDataValueAccess().getProducedTimeEStringParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_39);
            lv_producedTime_10_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDataValueRule());
            					}
            					set(
            						current,
            						"producedTime",
            						lv_producedTime_10_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalScml.g:1148:3: (otherlv_11= 'consumedTime' ( (lv_consumedTime_12_0= ruleEString ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==38) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalScml.g:1149:4: otherlv_11= 'consumedTime' ( (lv_consumedTime_12_0= ruleEString ) )
                    {
                    otherlv_11=(Token)match(input,38,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getDataValueAccess().getConsumedTimeKeyword_9_0());
                    			
                    // InternalScml.g:1153:4: ( (lv_consumedTime_12_0= ruleEString ) )
                    // InternalScml.g:1154:5: (lv_consumedTime_12_0= ruleEString )
                    {
                    // InternalScml.g:1154:5: (lv_consumedTime_12_0= ruleEString )
                    // InternalScml.g:1155:6: lv_consumedTime_12_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getDataValueAccess().getConsumedTimeEStringParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_consumedTime_12_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDataValueRule());
                    						}
                    						set(
                    							current,
                    							"consumedTime",
                    							lv_consumedTime_12_0,
                    							"ac.at.tuwien.big.Scml.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getDataValueAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataValue"


    // $ANTLR start "entryRuleParameter"
    // InternalScml.g:1181:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalScml.g:1181:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalScml.g:1182:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalScml.g:1188:1: ruleParameter returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        AntlrDatatypeRuleToken lv_unit_5_0 = null;

        Enumerator lv_type_9_0 = null;

        EObject lv_goalreferencevalue_14_0 = null;

        EObject lv_observedValue_19_0 = null;



        	enterRule();

        try {
            // InternalScml.g:1194:2: ( ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+ {...}?) ) ) )
            // InternalScml.g:1195:2: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+ {...}?) ) )
            {
            // InternalScml.g:1195:2: ( ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+ {...}?) ) )
            // InternalScml.g:1196:3: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+ {...}?) )
            {
            // InternalScml.g:1196:3: ( ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+ {...}?) )
            // InternalScml.g:1197:4: ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getParameterAccess().getUnorderedGroup());
            			
            // InternalScml.g:1200:4: ( ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+ {...}?)
            // InternalScml.g:1201:5: ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+ {...}?
            {
            // InternalScml.g:1201:5: ( ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=4;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==18) ) {
                    int LA26_2 = input.LA(2);

                    if ( getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 2) ) {
                        alt26=3;
                    }


                }
                else if ( LA26_0 >= RULE_STRING && LA26_0 <= RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 0) ) {
                    alt26=1;
                }
                else if ( LA26_0 == 43 && getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 1) ) {
                    alt26=2;
                }
                else if ( LA26_0 == 44 && getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 2) ) {
                    alt26=3;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalScml.g:1202:3: ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) )
            	    {
            	    // InternalScml.g:1202:3: ({...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) ) )
            	    // InternalScml.g:1203:4: {...}? => ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleParameter", "getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalScml.g:1203:103: ( ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) ) )
            	    // InternalScml.g:1204:5: ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getParameterAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalScml.g:1207:8: ({...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) ) )
            	    // InternalScml.g:1207:9: {...}? => ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleParameter", "true");
            	    }
            	    // InternalScml.g:1207:18: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) ) )
            	    // InternalScml.g:1207:19: ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'unit' otherlv_4= '=' ( (lv_unit_5_0= ruleEString ) ) otherlv_6= ',' otherlv_7= 'type' otherlv_8= '=' ( (lv_type_9_0= ruleParameterType ) ) otherlv_10= ')' otherlv_11= '{' otherlv_12= 'goalValue' otherlv_13= ':' ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) )
            	    {
            	    // InternalScml.g:1207:19: ( (lv_name_1_0= ruleEString ) )
            	    // InternalScml.g:1208:9: (lv_name_1_0= ruleEString )
            	    {
            	    // InternalScml.g:1208:9: (lv_name_1_0= ruleEString )
            	    // InternalScml.g:1209:10: lv_name_1_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getParameterAccess().getNameEStringParserRuleCall_0_0_0());
            	    									
            	    pushFollow(FOLLOW_17);
            	    lv_name_1_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getParameterRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_1_0,
            	    											"ac.at.tuwien.big.Scml.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    otherlv_2=(Token)match(input,19,FOLLOW_40); 

            	    								newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getLeftParenthesisKeyword_0_1());
            	    							
            	    otherlv_3=(Token)match(input,39,FOLLOW_13); 

            	    								newLeafNode(otherlv_3, grammarAccess.getParameterAccess().getUnitKeyword_0_2());
            	    							
            	    otherlv_4=(Token)match(input,21,FOLLOW_3); 

            	    								newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getEqualsSignKeyword_0_3());
            	    							
            	    // InternalScml.g:1238:8: ( (lv_unit_5_0= ruleEString ) )
            	    // InternalScml.g:1239:9: (lv_unit_5_0= ruleEString )
            	    {
            	    // InternalScml.g:1239:9: (lv_unit_5_0= ruleEString )
            	    // InternalScml.g:1240:10: lv_unit_5_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getParameterAccess().getUnitEStringParserRuleCall_0_4_0());
            	    									
            	    pushFollow(FOLLOW_32);
            	    lv_unit_5_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getParameterRule());
            	    										}
            	    										set(
            	    											current,
            	    											"unit",
            	    											lv_unit_5_0,
            	    											"ac.at.tuwien.big.Scml.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    otherlv_6=(Token)match(input,15,FOLLOW_41); 

            	    								newLeafNode(otherlv_6, grammarAccess.getParameterAccess().getCommaKeyword_0_5());
            	    							
            	    otherlv_7=(Token)match(input,40,FOLLOW_13); 

            	    								newLeafNode(otherlv_7, grammarAccess.getParameterAccess().getTypeKeyword_0_6());
            	    							
            	    otherlv_8=(Token)match(input,21,FOLLOW_42); 

            	    								newLeafNode(otherlv_8, grammarAccess.getParameterAccess().getEqualsSignKeyword_0_7());
            	    							
            	    // InternalScml.g:1269:8: ( (lv_type_9_0= ruleParameterType ) )
            	    // InternalScml.g:1270:9: (lv_type_9_0= ruleParameterType )
            	    {
            	    // InternalScml.g:1270:9: (lv_type_9_0= ruleParameterType )
            	    // InternalScml.g:1271:10: lv_type_9_0= ruleParameterType
            	    {

            	    										newCompositeNode(grammarAccess.getParameterAccess().getTypeParameterTypeEnumRuleCall_0_8_0());
            	    									
            	    pushFollow(FOLLOW_28);
            	    lv_type_9_0=ruleParameterType();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getParameterRule());
            	    										}
            	    										set(
            	    											current,
            	    											"type",
            	    											lv_type_9_0,
            	    											"ac.at.tuwien.big.Scml.ParameterType");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    otherlv_10=(Token)match(input,22,FOLLOW_4); 

            	    								newLeafNode(otherlv_10, grammarAccess.getParameterAccess().getRightParenthesisKeyword_0_9());
            	    							
            	    otherlv_11=(Token)match(input,12,FOLLOW_43); 

            	    								newLeafNode(otherlv_11, grammarAccess.getParameterAccess().getLeftCurlyBracketKeyword_0_10());
            	    							
            	    otherlv_12=(Token)match(input,41,FOLLOW_44); 

            	    								newLeafNode(otherlv_12, grammarAccess.getParameterAccess().getGoalValueKeyword_0_11());
            	    							
            	    otherlv_13=(Token)match(input,42,FOLLOW_45); 

            	    								newLeafNode(otherlv_13, grammarAccess.getParameterAccess().getColonKeyword_0_12());
            	    							
            	    // InternalScml.g:1304:8: ( (lv_goalreferencevalue_14_0= ruleGoalReferenceValue ) )
            	    // InternalScml.g:1305:9: (lv_goalreferencevalue_14_0= ruleGoalReferenceValue )
            	    {
            	    // InternalScml.g:1305:9: (lv_goalreferencevalue_14_0= ruleGoalReferenceValue )
            	    // InternalScml.g:1306:10: lv_goalreferencevalue_14_0= ruleGoalReferenceValue
            	    {

            	    										newCompositeNode(grammarAccess.getParameterAccess().getGoalreferencevalueGoalReferenceValueParserRuleCall_0_13_0());
            	    									
            	    pushFollow(FOLLOW_46);
            	    lv_goalreferencevalue_14_0=ruleGoalReferenceValue();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getParameterRule());
            	    										}
            	    										set(
            	    											current,
            	    											"goalreferencevalue",
            	    											lv_goalreferencevalue_14_0,
            	    											"ac.at.tuwien.big.Scml.GoalReferenceValue");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getParameterAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalScml.g:1329:3: ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) )
            	    {
            	    // InternalScml.g:1329:3: ({...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) ) )
            	    // InternalScml.g:1330:4: {...}? => ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleParameter", "getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalScml.g:1330:103: ( ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) ) )
            	    // InternalScml.g:1331:5: ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getParameterAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalScml.g:1334:8: ({...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) ) )
            	    // InternalScml.g:1334:9: {...}? => (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleParameter", "true");
            	    }
            	    // InternalScml.g:1334:18: (otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) ) )
            	    // InternalScml.g:1334:19: otherlv_15= 'dataSource' otherlv_16= ':' ( (otherlv_17= RULE_ID ) )
            	    {
            	    otherlv_15=(Token)match(input,43,FOLLOW_44); 

            	    								newLeafNode(otherlv_15, grammarAccess.getParameterAccess().getDataSourceKeyword_1_0());
            	    							
            	    otherlv_16=(Token)match(input,42,FOLLOW_18); 

            	    								newLeafNode(otherlv_16, grammarAccess.getParameterAccess().getColonKeyword_1_1());
            	    							
            	    // InternalScml.g:1342:8: ( (otherlv_17= RULE_ID ) )
            	    // InternalScml.g:1343:9: (otherlv_17= RULE_ID )
            	    {
            	    // InternalScml.g:1343:9: (otherlv_17= RULE_ID )
            	    // InternalScml.g:1344:10: otherlv_17= RULE_ID
            	    {

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getParameterRule());
            	    										}
            	    									
            	    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_46); 

            	    										newLeafNode(otherlv_17, grammarAccess.getParameterAccess().getComponentInfrastructureComponentCrossReference_1_2_0());
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getParameterAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalScml.g:1361:3: ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) )
            	    {
            	    // InternalScml.g:1361:3: ({...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) ) )
            	    // InternalScml.g:1362:4: {...}? => ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleParameter", "getUnorderedGroupHelper().canSelect(grammarAccess.getParameterAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalScml.g:1362:103: ( ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) ) )
            	    // InternalScml.g:1363:5: ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getParameterAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalScml.g:1366:8: ({...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' ) )
            	    // InternalScml.g:1366:9: {...}? => ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleParameter", "true");
            	    }
            	    // InternalScml.g:1366:18: ( (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}' )
            	    // InternalScml.g:1366:19: (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )? otherlv_20= '}'
            	    {
            	    // InternalScml.g:1366:19: (otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) ) )?
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==44) ) {
            	        alt25=1;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // InternalScml.g:1367:9: otherlv_18= 'observedValue' ( (lv_observedValue_19_0= ruleAggregatedValue ) )
            	            {
            	            otherlv_18=(Token)match(input,44,FOLLOW_4); 

            	            									newLeafNode(otherlv_18, grammarAccess.getParameterAccess().getObservedValueKeyword_2_0_0());
            	            								
            	            // InternalScml.g:1371:9: ( (lv_observedValue_19_0= ruleAggregatedValue ) )
            	            // InternalScml.g:1372:10: (lv_observedValue_19_0= ruleAggregatedValue )
            	            {
            	            // InternalScml.g:1372:10: (lv_observedValue_19_0= ruleAggregatedValue )
            	            // InternalScml.g:1373:11: lv_observedValue_19_0= ruleAggregatedValue
            	            {

            	            											newCompositeNode(grammarAccess.getParameterAccess().getObservedValueAggregatedValueParserRuleCall_2_0_1_0());
            	            										
            	            pushFollow(FOLLOW_10);
            	            lv_observedValue_19_0=ruleAggregatedValue();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getParameterRule());
            	            											}
            	            											set(
            	            												current,
            	            												"observedValue",
            	            												lv_observedValue_19_0,
            	            												"ac.at.tuwien.big.Scml.AggregatedValue");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    otherlv_20=(Token)match(input,18,FOLLOW_46); 

            	    								newLeafNode(otherlv_20, grammarAccess.getParameterAccess().getRightCurlyBracketKeyword_2_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getParameterAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getParameterAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleParameter", "getUnorderedGroupHelper().canLeave(grammarAccess.getParameterAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getParameterAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleBuildingComponent"
    // InternalScml.g:1412:1: entryRuleBuildingComponent returns [EObject current=null] : iv_ruleBuildingComponent= ruleBuildingComponent EOF ;
    public final EObject entryRuleBuildingComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBuildingComponent = null;


        try {
            // InternalScml.g:1412:58: (iv_ruleBuildingComponent= ruleBuildingComponent EOF )
            // InternalScml.g:1413:2: iv_ruleBuildingComponent= ruleBuildingComponent EOF
            {
             newCompositeNode(grammarAccess.getBuildingComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBuildingComponent=ruleBuildingComponent();

            state._fsp--;

             current =iv_ruleBuildingComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBuildingComponent"


    // $ANTLR start "ruleBuildingComponent"
    // InternalScml.g:1419:1: ruleBuildingComponent returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleBuildingComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_location_14_0 = null;

        EObject lv_produces_17_0 = null;

        EObject lv_produces_19_0 = null;

        EObject lv_parameter_22_0 = null;

        EObject lv_device_25_0 = null;

        EObject lv_device_27_0 = null;



        	enterRule();

        try {
            // InternalScml.g:1425:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) ) )
            // InternalScml.g:1426:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) )
            {
            // InternalScml.g:1426:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) )
            // InternalScml.g:1427:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) )
            {
            // InternalScml.g:1427:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) )
            // InternalScml.g:1428:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getBuildingComponentAccess().getUnorderedGroup());
            			
            // InternalScml.g:1431:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?)
            // InternalScml.g:1432:5: ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?
            {
            // InternalScml.g:1432:5: ( ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+
            int cnt32=0;
            loop32:
            do {
                int alt32=7;
                int LA32_0 = input.LA(1);

                if ( LA32_0 == 45 && getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 0) ) {
                    alt32=1;
                }
                else if ( LA32_0 == 47 && getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 1) ) {
                    alt32=2;
                }
                else if ( LA32_0 == 48 && getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 2) ) {
                    alt32=3;
                }
                else if ( LA32_0 == 49 && getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 3) ) {
                    alt32=4;
                }
                else if ( LA32_0 == 50 && getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 4) ) {
                    alt32=5;
                }
                else if ( ( LA32_0 == 18 || LA32_0 == 51 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 5) ) {
                    alt32=6;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalScml.g:1433:3: ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) )
            	    {
            	    // InternalScml.g:1433:3: ({...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) )
            	    // InternalScml.g:1434:4: {...}? => ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalScml.g:1434:111: ( ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) )
            	    // InternalScml.g:1435:5: ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalScml.g:1438:8: ({...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) )
            	    // InternalScml.g:1438:9: {...}? => (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "true");
            	    }
            	    // InternalScml.g:1438:18: (otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )? )
            	    // InternalScml.g:1438:19: otherlv_1= 'BuildingComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )?
            	    {
            	    otherlv_1=(Token)match(input,45,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getBuildingComponentAccess().getBuildingComponentKeyword_0_0());
            	    							
            	    // InternalScml.g:1442:8: ( (lv_name_2_0= ruleEString ) )
            	    // InternalScml.g:1443:9: (lv_name_2_0= ruleEString )
            	    {
            	    // InternalScml.g:1443:9: (lv_name_2_0= ruleEString )
            	    // InternalScml.g:1444:10: lv_name_2_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getBuildingComponentAccess().getNameEStringParserRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_4);
            	    lv_name_2_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getBuildingComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"ac.at.tuwien.big.Scml.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FOLLOW_47); 

            	    								newLeafNode(otherlv_3, grammarAccess.getBuildingComponentAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalScml.g:1465:8: (otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) ) )?
            	    int alt27=2;
            	    int LA27_0 = input.LA(1);

            	    if ( (LA27_0==46) ) {
            	        alt27=1;
            	    }
            	    switch (alt27) {
            	        case 1 :
            	            // InternalScml.g:1466:9: otherlv_4= 'buildingComponentSuper' ( (otherlv_5= RULE_ID ) )
            	            {
            	            otherlv_4=(Token)match(input,46,FOLLOW_18); 

            	            									newLeafNode(otherlv_4, grammarAccess.getBuildingComponentAccess().getBuildingComponentSuperKeyword_0_3_0());
            	            								
            	            // InternalScml.g:1470:9: ( (otherlv_5= RULE_ID ) )
            	            // InternalScml.g:1471:10: (otherlv_5= RULE_ID )
            	            {
            	            // InternalScml.g:1471:10: (otherlv_5= RULE_ID )
            	            // InternalScml.g:1472:11: otherlv_5= RULE_ID
            	            {

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getBuildingComponentRule());
            	            											}
            	            										
            	            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_48); 

            	            											newLeafNode(otherlv_5, grammarAccess.getBuildingComponentAccess().getIsPartOfInfrastructureComponentCrossReference_0_3_1_0());
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBuildingComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalScml.g:1490:3: ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) )
            	    {
            	    // InternalScml.g:1490:3: ({...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) )
            	    // InternalScml.g:1491:4: {...}? => ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalScml.g:1491:111: ( ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) )
            	    // InternalScml.g:1492:5: ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalScml.g:1495:8: ({...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) )
            	    // InternalScml.g:1495:9: {...}? => (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "true");
            	    }
            	    // InternalScml.g:1495:18: (otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' )
            	    // InternalScml.g:1495:19: otherlv_6= 'buildingComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']'
            	    {
            	    otherlv_6=(Token)match(input,47,FOLLOW_6); 

            	    								newLeafNode(otherlv_6, grammarAccess.getBuildingComponentAccess().getBuildingComponentSubKeyword_1_0());
            	    							
            	    otherlv_7=(Token)match(input,14,FOLLOW_18); 

            	    								newLeafNode(otherlv_7, grammarAccess.getBuildingComponentAccess().getLeftSquareBracketKeyword_1_1());
            	    							
            	    // InternalScml.g:1503:8: ( (otherlv_8= RULE_ID ) )
            	    // InternalScml.g:1504:9: (otherlv_8= RULE_ID )
            	    {
            	    // InternalScml.g:1504:9: (otherlv_8= RULE_ID )
            	    // InternalScml.g:1505:10: otherlv_8= RULE_ID
            	    {

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getBuildingComponentRule());
            	    										}
            	    									
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    										newLeafNode(otherlv_8, grammarAccess.getBuildingComponentAccess().getComposedOfInfrastructureComponentCrossReference_1_2_0());
            	    									

            	    }


            	    }

            	    // InternalScml.g:1516:8: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( (LA28_0==15) ) {
            	            alt28=1;
            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // InternalScml.g:1517:9: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
            	    	    {
            	    	    otherlv_9=(Token)match(input,15,FOLLOW_18); 

            	    	    									newLeafNode(otherlv_9, grammarAccess.getBuildingComponentAccess().getCommaKeyword_1_3_0());
            	    	    								
            	    	    // InternalScml.g:1521:9: ( (otherlv_10= RULE_ID ) )
            	    	    // InternalScml.g:1522:10: (otherlv_10= RULE_ID )
            	    	    {
            	    	    // InternalScml.g:1522:10: (otherlv_10= RULE_ID )
            	    	    // InternalScml.g:1523:11: otherlv_10= RULE_ID
            	    	    {

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getBuildingComponentRule());
            	    	    											}
            	    	    										
            	    	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    	    											newLeafNode(otherlv_10, grammarAccess.getBuildingComponentAccess().getComposedOfInfrastructureComponentCrossReference_1_3_1_0());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop28;
            	        }
            	    } while (true);

            	    otherlv_11=(Token)match(input,16,FOLLOW_48); 

            	    								newLeafNode(otherlv_11, grammarAccess.getBuildingComponentAccess().getRightSquareBracketKeyword_1_4());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBuildingComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalScml.g:1545:3: ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) )
            	    {
            	    // InternalScml.g:1545:3: ({...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) )
            	    // InternalScml.g:1546:4: {...}? => ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalScml.g:1546:111: ( ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) )
            	    // InternalScml.g:1547:5: ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalScml.g:1550:8: ({...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) )
            	    // InternalScml.g:1550:9: {...}? => (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "true");
            	    }
            	    // InternalScml.g:1550:18: (otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) )
            	    // InternalScml.g:1550:19: otherlv_12= 'buildingComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) )
            	    {
            	    otherlv_12=(Token)match(input,48,FOLLOW_44); 

            	    								newLeafNode(otherlv_12, grammarAccess.getBuildingComponentAccess().getBuildingComponentLocationKeyword_2_0());
            	    							
            	    otherlv_13=(Token)match(input,42,FOLLOW_49); 

            	    								newLeafNode(otherlv_13, grammarAccess.getBuildingComponentAccess().getColonKeyword_2_1());
            	    							
            	    // InternalScml.g:1558:8: ( (lv_location_14_0= ruleLocation ) )
            	    // InternalScml.g:1559:9: (lv_location_14_0= ruleLocation )
            	    {
            	    // InternalScml.g:1559:9: (lv_location_14_0= ruleLocation )
            	    // InternalScml.g:1560:10: lv_location_14_0= ruleLocation
            	    {

            	    										newCompositeNode(grammarAccess.getBuildingComponentAccess().getLocationLocationParserRuleCall_2_2_0());
            	    									
            	    pushFollow(FOLLOW_48);
            	    lv_location_14_0=ruleLocation();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getBuildingComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"location",
            	    											lv_location_14_0,
            	    											"ac.at.tuwien.big.Scml.Location");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBuildingComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalScml.g:1583:3: ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) )
            	    {
            	    // InternalScml.g:1583:3: ({...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) )
            	    // InternalScml.g:1584:4: {...}? => ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalScml.g:1584:111: ( ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) )
            	    // InternalScml.g:1585:5: ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalScml.g:1588:8: ({...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) )
            	    // InternalScml.g:1588:9: {...}? => (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "true");
            	    }
            	    // InternalScml.g:1588:18: (otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' )
            	    // InternalScml.g:1588:19: otherlv_15= 'buildingComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}'
            	    {
            	    otherlv_15=(Token)match(input,49,FOLLOW_4); 

            	    								newLeafNode(otherlv_15, grammarAccess.getBuildingComponentAccess().getBuildingComponentDataKeyword_3_0());
            	    							
            	    otherlv_16=(Token)match(input,12,FOLLOW_50); 

            	    								newLeafNode(otherlv_16, grammarAccess.getBuildingComponentAccess().getLeftCurlyBracketKeyword_3_1());
            	    							
            	    // InternalScml.g:1596:8: ( (lv_produces_17_0= ruleDataValue ) )
            	    // InternalScml.g:1597:9: (lv_produces_17_0= ruleDataValue )
            	    {
            	    // InternalScml.g:1597:9: (lv_produces_17_0= ruleDataValue )
            	    // InternalScml.g:1598:10: lv_produces_17_0= ruleDataValue
            	    {

            	    										newCompositeNode(grammarAccess.getBuildingComponentAccess().getProducesDataValueParserRuleCall_3_2_0());
            	    									
            	    pushFollow(FOLLOW_51);
            	    lv_produces_17_0=ruleDataValue();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getBuildingComponentRule());
            	    										}
            	    										add(
            	    											current,
            	    											"produces",
            	    											lv_produces_17_0,
            	    											"ac.at.tuwien.big.Scml.DataValue");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalScml.g:1615:8: (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==15) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // InternalScml.g:1616:9: otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) )
            	    	    {
            	    	    otherlv_18=(Token)match(input,15,FOLLOW_50); 

            	    	    									newLeafNode(otherlv_18, grammarAccess.getBuildingComponentAccess().getCommaKeyword_3_3_0());
            	    	    								
            	    	    // InternalScml.g:1620:9: ( (lv_produces_19_0= ruleDataValue ) )
            	    	    // InternalScml.g:1621:10: (lv_produces_19_0= ruleDataValue )
            	    	    {
            	    	    // InternalScml.g:1621:10: (lv_produces_19_0= ruleDataValue )
            	    	    // InternalScml.g:1622:11: lv_produces_19_0= ruleDataValue
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getBuildingComponentAccess().getProducesDataValueParserRuleCall_3_3_1_0());
            	    	    										
            	    	    pushFollow(FOLLOW_51);
            	    	    lv_produces_19_0=ruleDataValue();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getBuildingComponentRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"produces",
            	    	    												lv_produces_19_0,
            	    	    												"ac.at.tuwien.big.Scml.DataValue");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop29;
            	        }
            	    } while (true);

            	    otherlv_20=(Token)match(input,18,FOLLOW_48); 

            	    								newLeafNode(otherlv_20, grammarAccess.getBuildingComponentAccess().getRightCurlyBracketKeyword_3_4());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBuildingComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalScml.g:1650:3: ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) )
            	    {
            	    // InternalScml.g:1650:3: ({...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) )
            	    // InternalScml.g:1651:4: {...}? => ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalScml.g:1651:111: ( ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) )
            	    // InternalScml.g:1652:5: ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalScml.g:1655:8: ({...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) )
            	    // InternalScml.g:1655:9: {...}? => (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "true");
            	    }
            	    // InternalScml.g:1655:18: (otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) )
            	    // InternalScml.g:1655:19: otherlv_21= 'buildingComponentParameter' ( (lv_parameter_22_0= ruleParameter ) )
            	    {
            	    otherlv_21=(Token)match(input,50,FOLLOW_52); 

            	    								newLeafNode(otherlv_21, grammarAccess.getBuildingComponentAccess().getBuildingComponentParameterKeyword_4_0());
            	    							
            	    // InternalScml.g:1659:8: ( (lv_parameter_22_0= ruleParameter ) )
            	    // InternalScml.g:1660:9: (lv_parameter_22_0= ruleParameter )
            	    {
            	    // InternalScml.g:1660:9: (lv_parameter_22_0= ruleParameter )
            	    // InternalScml.g:1661:10: lv_parameter_22_0= ruleParameter
            	    {

            	    										newCompositeNode(grammarAccess.getBuildingComponentAccess().getParameterParameterParserRuleCall_4_1_0());
            	    									
            	    pushFollow(FOLLOW_48);
            	    lv_parameter_22_0=ruleParameter();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getBuildingComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"parameter",
            	    											lv_parameter_22_0,
            	    											"ac.at.tuwien.big.Scml.Parameter");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBuildingComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalScml.g:1684:3: ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) )
            	    {
            	    // InternalScml.g:1684:3: ({...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) )
            	    // InternalScml.g:1685:4: {...}? => ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 5)");
            	    }
            	    // InternalScml.g:1685:111: ( ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) )
            	    // InternalScml.g:1686:5: ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getBuildingComponentAccess().getUnorderedGroup(), 5);
            	    				
            	    // InternalScml.g:1689:8: ({...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) )
            	    // InternalScml.g:1689:9: {...}? => ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleBuildingComponent", "true");
            	    }
            	    // InternalScml.g:1689:18: ( (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' )
            	    // InternalScml.g:1689:19: (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}'
            	    {
            	    // InternalScml.g:1689:19: (otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )?
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==51) ) {
            	        alt31=1;
            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // InternalScml.g:1690:9: otherlv_23= 'buildingComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']'
            	            {
            	            otherlv_23=(Token)match(input,51,FOLLOW_6); 

            	            									newLeafNode(otherlv_23, grammarAccess.getBuildingComponentAccess().getBuildingComponentDevicesKeyword_5_0_0());
            	            								
            	            otherlv_24=(Token)match(input,14,FOLLOW_53); 

            	            									newLeafNode(otherlv_24, grammarAccess.getBuildingComponentAccess().getLeftSquareBracketKeyword_5_0_1());
            	            								
            	            // InternalScml.g:1698:9: ( (lv_device_25_0= ruleDevice ) )
            	            // InternalScml.g:1699:10: (lv_device_25_0= ruleDevice )
            	            {
            	            // InternalScml.g:1699:10: (lv_device_25_0= ruleDevice )
            	            // InternalScml.g:1700:11: lv_device_25_0= ruleDevice
            	            {

            	            											newCompositeNode(grammarAccess.getBuildingComponentAccess().getDeviceDeviceParserRuleCall_5_0_2_0());
            	            										
            	            pushFollow(FOLLOW_7);
            	            lv_device_25_0=ruleDevice();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getBuildingComponentRule());
            	            											}
            	            											add(
            	            												current,
            	            												"device",
            	            												lv_device_25_0,
            	            												"ac.at.tuwien.big.Scml.Device");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }

            	            // InternalScml.g:1717:9: (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )*
            	            loop30:
            	            do {
            	                int alt30=2;
            	                int LA30_0 = input.LA(1);

            	                if ( (LA30_0==15) ) {
            	                    alt30=1;
            	                }


            	                switch (alt30) {
            	            	case 1 :
            	            	    // InternalScml.g:1718:10: otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) )
            	            	    {
            	            	    otherlv_26=(Token)match(input,15,FOLLOW_53); 

            	            	    										newLeafNode(otherlv_26, grammarAccess.getBuildingComponentAccess().getCommaKeyword_5_0_3_0());
            	            	    									
            	            	    // InternalScml.g:1722:10: ( (lv_device_27_0= ruleDevice ) )
            	            	    // InternalScml.g:1723:11: (lv_device_27_0= ruleDevice )
            	            	    {
            	            	    // InternalScml.g:1723:11: (lv_device_27_0= ruleDevice )
            	            	    // InternalScml.g:1724:12: lv_device_27_0= ruleDevice
            	            	    {

            	            	    												newCompositeNode(grammarAccess.getBuildingComponentAccess().getDeviceDeviceParserRuleCall_5_0_3_1_0());
            	            	    											
            	            	    pushFollow(FOLLOW_7);
            	            	    lv_device_27_0=ruleDevice();

            	            	    state._fsp--;


            	            	    												if (current==null) {
            	            	    													current = createModelElementForParent(grammarAccess.getBuildingComponentRule());
            	            	    												}
            	            	    												add(
            	            	    													current,
            	            	    													"device",
            	            	    													lv_device_27_0,
            	            	    													"ac.at.tuwien.big.Scml.Device");
            	            	    												afterParserOrEnumRuleCall();
            	            	    											

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop30;
            	                }
            	            } while (true);

            	            otherlv_28=(Token)match(input,16,FOLLOW_10); 

            	            									newLeafNode(otherlv_28, grammarAccess.getBuildingComponentAccess().getRightSquareBracketKeyword_5_0_4());
            	            								

            	            }
            	            break;

            	    }

            	    otherlv_29=(Token)match(input,18,FOLLOW_48); 

            	    								newLeafNode(otherlv_29, grammarAccess.getBuildingComponentAccess().getRightCurlyBracketKeyword_5_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getBuildingComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getBuildingComponentAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleBuildingComponent", "getUnorderedGroupHelper().canLeave(grammarAccess.getBuildingComponentAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getBuildingComponentAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBuildingComponent"


    // $ANTLR start "entryRuleTransportationComponent"
    // InternalScml.g:1768:1: entryRuleTransportationComponent returns [EObject current=null] : iv_ruleTransportationComponent= ruleTransportationComponent EOF ;
    public final EObject entryRuleTransportationComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransportationComponent = null;


        try {
            // InternalScml.g:1768:64: (iv_ruleTransportationComponent= ruleTransportationComponent EOF )
            // InternalScml.g:1769:2: iv_ruleTransportationComponent= ruleTransportationComponent EOF
            {
             newCompositeNode(grammarAccess.getTransportationComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransportationComponent=ruleTransportationComponent();

            state._fsp--;

             current =iv_ruleTransportationComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransportationComponent"


    // $ANTLR start "ruleTransportationComponent"
    // InternalScml.g:1775:1: ruleTransportationComponent returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleTransportationComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_location_14_0 = null;

        EObject lv_produces_17_0 = null;

        EObject lv_produces_19_0 = null;

        EObject lv_parameter_22_0 = null;

        EObject lv_device_25_0 = null;

        EObject lv_device_27_0 = null;



        	enterRule();

        try {
            // InternalScml.g:1781:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) ) )
            // InternalScml.g:1782:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) )
            {
            // InternalScml.g:1782:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) )
            // InternalScml.g:1783:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) )
            {
            // InternalScml.g:1783:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) )
            // InternalScml.g:1784:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getTransportationComponentAccess().getUnorderedGroup());
            			
            // InternalScml.g:1787:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?)
            // InternalScml.g:1788:5: ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?
            {
            // InternalScml.g:1788:5: ( ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+
            int cnt38=0;
            loop38:
            do {
                int alt38=7;
                int LA38_0 = input.LA(1);

                if ( LA38_0 == 52 && getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 0) ) {
                    alt38=1;
                }
                else if ( LA38_0 == 54 && getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 1) ) {
                    alt38=2;
                }
                else if ( LA38_0 == 55 && getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 2) ) {
                    alt38=3;
                }
                else if ( LA38_0 == 56 && getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 3) ) {
                    alt38=4;
                }
                else if ( LA38_0 == 57 && getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 4) ) {
                    alt38=5;
                }
                else if ( ( LA38_0 == 18 || LA38_0 == 58 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 5) ) {
                    alt38=6;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalScml.g:1789:3: ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) )
            	    {
            	    // InternalScml.g:1789:3: ({...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) )
            	    // InternalScml.g:1790:4: {...}? => ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalScml.g:1790:117: ( ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) )
            	    // InternalScml.g:1791:5: ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalScml.g:1794:8: ({...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) )
            	    // InternalScml.g:1794:9: {...}? => (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "true");
            	    }
            	    // InternalScml.g:1794:18: (otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )? )
            	    // InternalScml.g:1794:19: otherlv_1= 'TransportationComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )?
            	    {
            	    otherlv_1=(Token)match(input,52,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getTransportationComponentAccess().getTransportationComponentKeyword_0_0());
            	    							
            	    // InternalScml.g:1798:8: ( (lv_name_2_0= ruleEString ) )
            	    // InternalScml.g:1799:9: (lv_name_2_0= ruleEString )
            	    {
            	    // InternalScml.g:1799:9: (lv_name_2_0= ruleEString )
            	    // InternalScml.g:1800:10: lv_name_2_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getTransportationComponentAccess().getNameEStringParserRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_4);
            	    lv_name_2_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTransportationComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"ac.at.tuwien.big.Scml.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FOLLOW_54); 

            	    								newLeafNode(otherlv_3, grammarAccess.getTransportationComponentAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalScml.g:1821:8: (otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) ) )?
            	    int alt33=2;
            	    int LA33_0 = input.LA(1);

            	    if ( (LA33_0==53) ) {
            	        alt33=1;
            	    }
            	    switch (alt33) {
            	        case 1 :
            	            // InternalScml.g:1822:9: otherlv_4= 'transportationComponentSuper' ( (otherlv_5= RULE_ID ) )
            	            {
            	            otherlv_4=(Token)match(input,53,FOLLOW_18); 

            	            									newLeafNode(otherlv_4, grammarAccess.getTransportationComponentAccess().getTransportationComponentSuperKeyword_0_3_0());
            	            								
            	            // InternalScml.g:1826:9: ( (otherlv_5= RULE_ID ) )
            	            // InternalScml.g:1827:10: (otherlv_5= RULE_ID )
            	            {
            	            // InternalScml.g:1827:10: (otherlv_5= RULE_ID )
            	            // InternalScml.g:1828:11: otherlv_5= RULE_ID
            	            {

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getTransportationComponentRule());
            	            											}
            	            										
            	            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_55); 

            	            											newLeafNode(otherlv_5, grammarAccess.getTransportationComponentAccess().getIsPartOfInfrastructureComponentCrossReference_0_3_1_0());
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransportationComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalScml.g:1846:3: ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) )
            	    {
            	    // InternalScml.g:1846:3: ({...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) )
            	    // InternalScml.g:1847:4: {...}? => ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalScml.g:1847:117: ( ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) )
            	    // InternalScml.g:1848:5: ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalScml.g:1851:8: ({...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) )
            	    // InternalScml.g:1851:9: {...}? => (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "true");
            	    }
            	    // InternalScml.g:1851:18: (otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' )
            	    // InternalScml.g:1851:19: otherlv_6= 'transportationComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']'
            	    {
            	    otherlv_6=(Token)match(input,54,FOLLOW_6); 

            	    								newLeafNode(otherlv_6, grammarAccess.getTransportationComponentAccess().getTransportationComponentSubKeyword_1_0());
            	    							
            	    otherlv_7=(Token)match(input,14,FOLLOW_18); 

            	    								newLeafNode(otherlv_7, grammarAccess.getTransportationComponentAccess().getLeftSquareBracketKeyword_1_1());
            	    							
            	    // InternalScml.g:1859:8: ( (otherlv_8= RULE_ID ) )
            	    // InternalScml.g:1860:9: (otherlv_8= RULE_ID )
            	    {
            	    // InternalScml.g:1860:9: (otherlv_8= RULE_ID )
            	    // InternalScml.g:1861:10: otherlv_8= RULE_ID
            	    {

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getTransportationComponentRule());
            	    										}
            	    									
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    										newLeafNode(otherlv_8, grammarAccess.getTransportationComponentAccess().getComposedOfInfrastructureComponentCrossReference_1_2_0());
            	    									

            	    }


            	    }

            	    // InternalScml.g:1872:8: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==15) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // InternalScml.g:1873:9: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
            	    	    {
            	    	    otherlv_9=(Token)match(input,15,FOLLOW_18); 

            	    	    									newLeafNode(otherlv_9, grammarAccess.getTransportationComponentAccess().getCommaKeyword_1_3_0());
            	    	    								
            	    	    // InternalScml.g:1877:9: ( (otherlv_10= RULE_ID ) )
            	    	    // InternalScml.g:1878:10: (otherlv_10= RULE_ID )
            	    	    {
            	    	    // InternalScml.g:1878:10: (otherlv_10= RULE_ID )
            	    	    // InternalScml.g:1879:11: otherlv_10= RULE_ID
            	    	    {

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getTransportationComponentRule());
            	    	    											}
            	    	    										
            	    	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    	    											newLeafNode(otherlv_10, grammarAccess.getTransportationComponentAccess().getComposedOfInfrastructureComponentCrossReference_1_3_1_0());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop34;
            	        }
            	    } while (true);

            	    otherlv_11=(Token)match(input,16,FOLLOW_55); 

            	    								newLeafNode(otherlv_11, grammarAccess.getTransportationComponentAccess().getRightSquareBracketKeyword_1_4());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransportationComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalScml.g:1901:3: ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) )
            	    {
            	    // InternalScml.g:1901:3: ({...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) )
            	    // InternalScml.g:1902:4: {...}? => ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalScml.g:1902:117: ( ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) )
            	    // InternalScml.g:1903:5: ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalScml.g:1906:8: ({...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) )
            	    // InternalScml.g:1906:9: {...}? => (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "true");
            	    }
            	    // InternalScml.g:1906:18: (otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) )
            	    // InternalScml.g:1906:19: otherlv_12= 'transportComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) )
            	    {
            	    otherlv_12=(Token)match(input,55,FOLLOW_44); 

            	    								newLeafNode(otherlv_12, grammarAccess.getTransportationComponentAccess().getTransportComponentLocationKeyword_2_0());
            	    							
            	    otherlv_13=(Token)match(input,42,FOLLOW_49); 

            	    								newLeafNode(otherlv_13, grammarAccess.getTransportationComponentAccess().getColonKeyword_2_1());
            	    							
            	    // InternalScml.g:1914:8: ( (lv_location_14_0= ruleLocation ) )
            	    // InternalScml.g:1915:9: (lv_location_14_0= ruleLocation )
            	    {
            	    // InternalScml.g:1915:9: (lv_location_14_0= ruleLocation )
            	    // InternalScml.g:1916:10: lv_location_14_0= ruleLocation
            	    {

            	    										newCompositeNode(grammarAccess.getTransportationComponentAccess().getLocationLocationParserRuleCall_2_2_0());
            	    									
            	    pushFollow(FOLLOW_55);
            	    lv_location_14_0=ruleLocation();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTransportationComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"location",
            	    											lv_location_14_0,
            	    											"ac.at.tuwien.big.Scml.Location");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransportationComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalScml.g:1939:3: ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) )
            	    {
            	    // InternalScml.g:1939:3: ({...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) )
            	    // InternalScml.g:1940:4: {...}? => ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalScml.g:1940:117: ( ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) )
            	    // InternalScml.g:1941:5: ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalScml.g:1944:8: ({...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) )
            	    // InternalScml.g:1944:9: {...}? => (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "true");
            	    }
            	    // InternalScml.g:1944:18: (otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' )
            	    // InternalScml.g:1944:19: otherlv_15= 'transportComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}'
            	    {
            	    otherlv_15=(Token)match(input,56,FOLLOW_4); 

            	    								newLeafNode(otherlv_15, grammarAccess.getTransportationComponentAccess().getTransportComponentDataKeyword_3_0());
            	    							
            	    otherlv_16=(Token)match(input,12,FOLLOW_50); 

            	    								newLeafNode(otherlv_16, grammarAccess.getTransportationComponentAccess().getLeftCurlyBracketKeyword_3_1());
            	    							
            	    // InternalScml.g:1952:8: ( (lv_produces_17_0= ruleDataValue ) )
            	    // InternalScml.g:1953:9: (lv_produces_17_0= ruleDataValue )
            	    {
            	    // InternalScml.g:1953:9: (lv_produces_17_0= ruleDataValue )
            	    // InternalScml.g:1954:10: lv_produces_17_0= ruleDataValue
            	    {

            	    										newCompositeNode(grammarAccess.getTransportationComponentAccess().getProducesDataValueParserRuleCall_3_2_0());
            	    									
            	    pushFollow(FOLLOW_51);
            	    lv_produces_17_0=ruleDataValue();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTransportationComponentRule());
            	    										}
            	    										add(
            	    											current,
            	    											"produces",
            	    											lv_produces_17_0,
            	    											"ac.at.tuwien.big.Scml.DataValue");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalScml.g:1971:8: (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )*
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==15) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // InternalScml.g:1972:9: otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) )
            	    	    {
            	    	    otherlv_18=(Token)match(input,15,FOLLOW_50); 

            	    	    									newLeafNode(otherlv_18, grammarAccess.getTransportationComponentAccess().getCommaKeyword_3_3_0());
            	    	    								
            	    	    // InternalScml.g:1976:9: ( (lv_produces_19_0= ruleDataValue ) )
            	    	    // InternalScml.g:1977:10: (lv_produces_19_0= ruleDataValue )
            	    	    {
            	    	    // InternalScml.g:1977:10: (lv_produces_19_0= ruleDataValue )
            	    	    // InternalScml.g:1978:11: lv_produces_19_0= ruleDataValue
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getTransportationComponentAccess().getProducesDataValueParserRuleCall_3_3_1_0());
            	    	    										
            	    	    pushFollow(FOLLOW_51);
            	    	    lv_produces_19_0=ruleDataValue();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getTransportationComponentRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"produces",
            	    	    												lv_produces_19_0,
            	    	    												"ac.at.tuwien.big.Scml.DataValue");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop35;
            	        }
            	    } while (true);

            	    otherlv_20=(Token)match(input,18,FOLLOW_55); 

            	    								newLeafNode(otherlv_20, grammarAccess.getTransportationComponentAccess().getRightCurlyBracketKeyword_3_4());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransportationComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalScml.g:2006:3: ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) )
            	    {
            	    // InternalScml.g:2006:3: ({...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) )
            	    // InternalScml.g:2007:4: {...}? => ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalScml.g:2007:117: ( ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) )
            	    // InternalScml.g:2008:5: ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalScml.g:2011:8: ({...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) )
            	    // InternalScml.g:2011:9: {...}? => (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "true");
            	    }
            	    // InternalScml.g:2011:18: (otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) )
            	    // InternalScml.g:2011:19: otherlv_21= 'transportComponentParameter' ( (lv_parameter_22_0= ruleParameter ) )
            	    {
            	    otherlv_21=(Token)match(input,57,FOLLOW_52); 

            	    								newLeafNode(otherlv_21, grammarAccess.getTransportationComponentAccess().getTransportComponentParameterKeyword_4_0());
            	    							
            	    // InternalScml.g:2015:8: ( (lv_parameter_22_0= ruleParameter ) )
            	    // InternalScml.g:2016:9: (lv_parameter_22_0= ruleParameter )
            	    {
            	    // InternalScml.g:2016:9: (lv_parameter_22_0= ruleParameter )
            	    // InternalScml.g:2017:10: lv_parameter_22_0= ruleParameter
            	    {

            	    										newCompositeNode(grammarAccess.getTransportationComponentAccess().getParameterParameterParserRuleCall_4_1_0());
            	    									
            	    pushFollow(FOLLOW_55);
            	    lv_parameter_22_0=ruleParameter();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getTransportationComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"parameter",
            	    											lv_parameter_22_0,
            	    											"ac.at.tuwien.big.Scml.Parameter");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransportationComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalScml.g:2040:3: ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) )
            	    {
            	    // InternalScml.g:2040:3: ({...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) )
            	    // InternalScml.g:2041:4: {...}? => ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 5)");
            	    }
            	    // InternalScml.g:2041:117: ( ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) )
            	    // InternalScml.g:2042:5: ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getTransportationComponentAccess().getUnorderedGroup(), 5);
            	    				
            	    // InternalScml.g:2045:8: ({...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) )
            	    // InternalScml.g:2045:9: {...}? => ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleTransportationComponent", "true");
            	    }
            	    // InternalScml.g:2045:18: ( (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' )
            	    // InternalScml.g:2045:19: (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}'
            	    {
            	    // InternalScml.g:2045:19: (otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )?
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==58) ) {
            	        alt37=1;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // InternalScml.g:2046:9: otherlv_23= 'transportComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']'
            	            {
            	            otherlv_23=(Token)match(input,58,FOLLOW_6); 

            	            									newLeafNode(otherlv_23, grammarAccess.getTransportationComponentAccess().getTransportComponentDevicesKeyword_5_0_0());
            	            								
            	            otherlv_24=(Token)match(input,14,FOLLOW_53); 

            	            									newLeafNode(otherlv_24, grammarAccess.getTransportationComponentAccess().getLeftSquareBracketKeyword_5_0_1());
            	            								
            	            // InternalScml.g:2054:9: ( (lv_device_25_0= ruleDevice ) )
            	            // InternalScml.g:2055:10: (lv_device_25_0= ruleDevice )
            	            {
            	            // InternalScml.g:2055:10: (lv_device_25_0= ruleDevice )
            	            // InternalScml.g:2056:11: lv_device_25_0= ruleDevice
            	            {

            	            											newCompositeNode(grammarAccess.getTransportationComponentAccess().getDeviceDeviceParserRuleCall_5_0_2_0());
            	            										
            	            pushFollow(FOLLOW_7);
            	            lv_device_25_0=ruleDevice();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getTransportationComponentRule());
            	            											}
            	            											add(
            	            												current,
            	            												"device",
            	            												lv_device_25_0,
            	            												"ac.at.tuwien.big.Scml.Device");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }

            	            // InternalScml.g:2073:9: (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )*
            	            loop36:
            	            do {
            	                int alt36=2;
            	                int LA36_0 = input.LA(1);

            	                if ( (LA36_0==15) ) {
            	                    alt36=1;
            	                }


            	                switch (alt36) {
            	            	case 1 :
            	            	    // InternalScml.g:2074:10: otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) )
            	            	    {
            	            	    otherlv_26=(Token)match(input,15,FOLLOW_53); 

            	            	    										newLeafNode(otherlv_26, grammarAccess.getTransportationComponentAccess().getCommaKeyword_5_0_3_0());
            	            	    									
            	            	    // InternalScml.g:2078:10: ( (lv_device_27_0= ruleDevice ) )
            	            	    // InternalScml.g:2079:11: (lv_device_27_0= ruleDevice )
            	            	    {
            	            	    // InternalScml.g:2079:11: (lv_device_27_0= ruleDevice )
            	            	    // InternalScml.g:2080:12: lv_device_27_0= ruleDevice
            	            	    {

            	            	    												newCompositeNode(grammarAccess.getTransportationComponentAccess().getDeviceDeviceParserRuleCall_5_0_3_1_0());
            	            	    											
            	            	    pushFollow(FOLLOW_7);
            	            	    lv_device_27_0=ruleDevice();

            	            	    state._fsp--;


            	            	    												if (current==null) {
            	            	    													current = createModelElementForParent(grammarAccess.getTransportationComponentRule());
            	            	    												}
            	            	    												add(
            	            	    													current,
            	            	    													"device",
            	            	    													lv_device_27_0,
            	            	    													"ac.at.tuwien.big.Scml.Device");
            	            	    												afterParserOrEnumRuleCall();
            	            	    											

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop36;
            	                }
            	            } while (true);

            	            otherlv_28=(Token)match(input,16,FOLLOW_10); 

            	            									newLeafNode(otherlv_28, grammarAccess.getTransportationComponentAccess().getRightSquareBracketKeyword_5_0_4());
            	            								

            	            }
            	            break;

            	    }

            	    otherlv_29=(Token)match(input,18,FOLLOW_55); 

            	    								newLeafNode(otherlv_29, grammarAccess.getTransportationComponentAccess().getRightCurlyBracketKeyword_5_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getTransportationComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getTransportationComponentAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleTransportationComponent", "getUnorderedGroupHelper().canLeave(grammarAccess.getTransportationComponentAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getTransportationComponentAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransportationComponent"


    // $ANTLR start "entryRuleEnvironmentalComponent"
    // InternalScml.g:2124:1: entryRuleEnvironmentalComponent returns [EObject current=null] : iv_ruleEnvironmentalComponent= ruleEnvironmentalComponent EOF ;
    public final EObject entryRuleEnvironmentalComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnvironmentalComponent = null;


        try {
            // InternalScml.g:2124:63: (iv_ruleEnvironmentalComponent= ruleEnvironmentalComponent EOF )
            // InternalScml.g:2125:2: iv_ruleEnvironmentalComponent= ruleEnvironmentalComponent EOF
            {
             newCompositeNode(grammarAccess.getEnvironmentalComponentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnvironmentalComponent=ruleEnvironmentalComponent();

            state._fsp--;

             current =iv_ruleEnvironmentalComponent; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnvironmentalComponent"


    // $ANTLR start "ruleEnvironmentalComponent"
    // InternalScml.g:2131:1: ruleEnvironmentalComponent returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) ) ;
    public final EObject ruleEnvironmentalComponent() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_location_14_0 = null;

        EObject lv_produces_17_0 = null;

        EObject lv_produces_19_0 = null;

        EObject lv_parameter_22_0 = null;

        EObject lv_device_25_0 = null;

        EObject lv_device_27_0 = null;



        	enterRule();

        try {
            // InternalScml.g:2137:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) ) )
            // InternalScml.g:2138:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) )
            {
            // InternalScml.g:2138:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) ) )
            // InternalScml.g:2139:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) )
            {
            // InternalScml.g:2139:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?) )
            // InternalScml.g:2140:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup());
            			
            // InternalScml.g:2143:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?)
            // InternalScml.g:2144:5: ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+ {...}?
            {
            // InternalScml.g:2144:5: ( ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) ) )+
            int cnt44=0;
            loop44:
            do {
                int alt44=7;
                int LA44_0 = input.LA(1);

                if ( LA44_0 == 59 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 0) ) {
                    alt44=1;
                }
                else if ( LA44_0 == 61 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 1) ) {
                    alt44=2;
                }
                else if ( LA44_0 == 62 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 2) ) {
                    alt44=3;
                }
                else if ( LA44_0 == 63 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 3) ) {
                    alt44=4;
                }
                else if ( LA44_0 == 64 && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 4) ) {
                    alt44=5;
                }
                else if ( ( LA44_0 == 18 || LA44_0 == 65 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 5) ) {
                    alt44=6;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalScml.g:2145:3: ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) )
            	    {
            	    // InternalScml.g:2145:3: ({...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) ) )
            	    // InternalScml.g:2146:4: {...}? => ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalScml.g:2146:116: ( ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) ) )
            	    // InternalScml.g:2147:5: ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalScml.g:2150:8: ({...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? ) )
            	    // InternalScml.g:2150:9: {...}? => (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "true");
            	    }
            	    // InternalScml.g:2150:18: (otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )? )
            	    // InternalScml.g:2150:19: otherlv_1= 'EnvironmentalComponent' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )?
            	    {
            	    otherlv_1=(Token)match(input,59,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getEnvironmentalComponentAccess().getEnvironmentalComponentKeyword_0_0());
            	    							
            	    // InternalScml.g:2154:8: ( (lv_name_2_0= ruleEString ) )
            	    // InternalScml.g:2155:9: (lv_name_2_0= ruleEString )
            	    {
            	    // InternalScml.g:2155:9: (lv_name_2_0= ruleEString )
            	    // InternalScml.g:2156:10: lv_name_2_0= ruleEString
            	    {

            	    										newCompositeNode(grammarAccess.getEnvironmentalComponentAccess().getNameEStringParserRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_4);
            	    lv_name_2_0=ruleEString();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getEnvironmentalComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"ac.at.tuwien.big.Scml.EString");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    otherlv_3=(Token)match(input,12,FOLLOW_56); 

            	    								newLeafNode(otherlv_3, grammarAccess.getEnvironmentalComponentAccess().getLeftCurlyBracketKeyword_0_2());
            	    							
            	    // InternalScml.g:2177:8: (otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) ) )?
            	    int alt39=2;
            	    int LA39_0 = input.LA(1);

            	    if ( (LA39_0==60) ) {
            	        alt39=1;
            	    }
            	    switch (alt39) {
            	        case 1 :
            	            // InternalScml.g:2178:9: otherlv_4= 'environmentalComponentSuper' ( (otherlv_5= RULE_ID ) )
            	            {
            	            otherlv_4=(Token)match(input,60,FOLLOW_18); 

            	            									newLeafNode(otherlv_4, grammarAccess.getEnvironmentalComponentAccess().getEnvironmentalComponentSuperKeyword_0_3_0());
            	            								
            	            // InternalScml.g:2182:9: ( (otherlv_5= RULE_ID ) )
            	            // InternalScml.g:2183:10: (otherlv_5= RULE_ID )
            	            {
            	            // InternalScml.g:2183:10: (otherlv_5= RULE_ID )
            	            // InternalScml.g:2184:11: otherlv_5= RULE_ID
            	            {

            	            											if (current==null) {
            	            												current = createModelElement(grammarAccess.getEnvironmentalComponentRule());
            	            											}
            	            										
            	            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_57); 

            	            											newLeafNode(otherlv_5, grammarAccess.getEnvironmentalComponentAccess().getIsPartOfInfrastructureComponentCrossReference_0_3_1_0());
            	            										

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalScml.g:2202:3: ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) )
            	    {
            	    // InternalScml.g:2202:3: ({...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) ) )
            	    // InternalScml.g:2203:4: {...}? => ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalScml.g:2203:116: ( ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) ) )
            	    // InternalScml.g:2204:5: ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalScml.g:2207:8: ({...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' ) )
            	    // InternalScml.g:2207:9: {...}? => (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "true");
            	    }
            	    // InternalScml.g:2207:18: (otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']' )
            	    // InternalScml.g:2207:19: otherlv_6= 'environmentalComponentSub' otherlv_7= '[' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ']'
            	    {
            	    otherlv_6=(Token)match(input,61,FOLLOW_6); 

            	    								newLeafNode(otherlv_6, grammarAccess.getEnvironmentalComponentAccess().getEnvironmentalComponentSubKeyword_1_0());
            	    							
            	    otherlv_7=(Token)match(input,14,FOLLOW_18); 

            	    								newLeafNode(otherlv_7, grammarAccess.getEnvironmentalComponentAccess().getLeftSquareBracketKeyword_1_1());
            	    							
            	    // InternalScml.g:2215:8: ( (otherlv_8= RULE_ID ) )
            	    // InternalScml.g:2216:9: (otherlv_8= RULE_ID )
            	    {
            	    // InternalScml.g:2216:9: (otherlv_8= RULE_ID )
            	    // InternalScml.g:2217:10: otherlv_8= RULE_ID
            	    {

            	    										if (current==null) {
            	    											current = createModelElement(grammarAccess.getEnvironmentalComponentRule());
            	    										}
            	    									
            	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    										newLeafNode(otherlv_8, grammarAccess.getEnvironmentalComponentAccess().getComposedOfInfrastructureComponentCrossReference_1_2_0());
            	    									

            	    }


            	    }

            	    // InternalScml.g:2228:8: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
            	    loop40:
            	    do {
            	        int alt40=2;
            	        int LA40_0 = input.LA(1);

            	        if ( (LA40_0==15) ) {
            	            alt40=1;
            	        }


            	        switch (alt40) {
            	    	case 1 :
            	    	    // InternalScml.g:2229:9: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
            	    	    {
            	    	    otherlv_9=(Token)match(input,15,FOLLOW_18); 

            	    	    									newLeafNode(otherlv_9, grammarAccess.getEnvironmentalComponentAccess().getCommaKeyword_1_3_0());
            	    	    								
            	    	    // InternalScml.g:2233:9: ( (otherlv_10= RULE_ID ) )
            	    	    // InternalScml.g:2234:10: (otherlv_10= RULE_ID )
            	    	    {
            	    	    // InternalScml.g:2234:10: (otherlv_10= RULE_ID )
            	    	    // InternalScml.g:2235:11: otherlv_10= RULE_ID
            	    	    {

            	    	    											if (current==null) {
            	    	    												current = createModelElement(grammarAccess.getEnvironmentalComponentRule());
            	    	    											}
            	    	    										
            	    	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_7); 

            	    	    											newLeafNode(otherlv_10, grammarAccess.getEnvironmentalComponentAccess().getComposedOfInfrastructureComponentCrossReference_1_3_1_0());
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop40;
            	        }
            	    } while (true);

            	    otherlv_11=(Token)match(input,16,FOLLOW_57); 

            	    								newLeafNode(otherlv_11, grammarAccess.getEnvironmentalComponentAccess().getRightSquareBracketKeyword_1_4());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalScml.g:2257:3: ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) )
            	    {
            	    // InternalScml.g:2257:3: ({...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) ) )
            	    // InternalScml.g:2258:4: {...}? => ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalScml.g:2258:116: ( ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) ) )
            	    // InternalScml.g:2259:5: ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalScml.g:2262:8: ({...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) ) )
            	    // InternalScml.g:2262:9: {...}? => (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "true");
            	    }
            	    // InternalScml.g:2262:18: (otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) ) )
            	    // InternalScml.g:2262:19: otherlv_12= 'environmentalComponentLocation' otherlv_13= ':' ( (lv_location_14_0= ruleLocation ) )
            	    {
            	    otherlv_12=(Token)match(input,62,FOLLOW_44); 

            	    								newLeafNode(otherlv_12, grammarAccess.getEnvironmentalComponentAccess().getEnvironmentalComponentLocationKeyword_2_0());
            	    							
            	    otherlv_13=(Token)match(input,42,FOLLOW_49); 

            	    								newLeafNode(otherlv_13, grammarAccess.getEnvironmentalComponentAccess().getColonKeyword_2_1());
            	    							
            	    // InternalScml.g:2270:8: ( (lv_location_14_0= ruleLocation ) )
            	    // InternalScml.g:2271:9: (lv_location_14_0= ruleLocation )
            	    {
            	    // InternalScml.g:2271:9: (lv_location_14_0= ruleLocation )
            	    // InternalScml.g:2272:10: lv_location_14_0= ruleLocation
            	    {

            	    										newCompositeNode(grammarAccess.getEnvironmentalComponentAccess().getLocationLocationParserRuleCall_2_2_0());
            	    									
            	    pushFollow(FOLLOW_57);
            	    lv_location_14_0=ruleLocation();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getEnvironmentalComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"location",
            	    											lv_location_14_0,
            	    											"ac.at.tuwien.big.Scml.Location");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalScml.g:2295:3: ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) )
            	    {
            	    // InternalScml.g:2295:3: ({...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) ) )
            	    // InternalScml.g:2296:4: {...}? => ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalScml.g:2296:116: ( ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) ) )
            	    // InternalScml.g:2297:5: ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalScml.g:2300:8: ({...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' ) )
            	    // InternalScml.g:2300:9: {...}? => (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "true");
            	    }
            	    // InternalScml.g:2300:18: (otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}' )
            	    // InternalScml.g:2300:19: otherlv_15= 'environmentalComponentData' otherlv_16= '{' ( (lv_produces_17_0= ruleDataValue ) ) (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )* otherlv_20= '}'
            	    {
            	    otherlv_15=(Token)match(input,63,FOLLOW_4); 

            	    								newLeafNode(otherlv_15, grammarAccess.getEnvironmentalComponentAccess().getEnvironmentalComponentDataKeyword_3_0());
            	    							
            	    otherlv_16=(Token)match(input,12,FOLLOW_50); 

            	    								newLeafNode(otherlv_16, grammarAccess.getEnvironmentalComponentAccess().getLeftCurlyBracketKeyword_3_1());
            	    							
            	    // InternalScml.g:2308:8: ( (lv_produces_17_0= ruleDataValue ) )
            	    // InternalScml.g:2309:9: (lv_produces_17_0= ruleDataValue )
            	    {
            	    // InternalScml.g:2309:9: (lv_produces_17_0= ruleDataValue )
            	    // InternalScml.g:2310:10: lv_produces_17_0= ruleDataValue
            	    {

            	    										newCompositeNode(grammarAccess.getEnvironmentalComponentAccess().getProducesDataValueParserRuleCall_3_2_0());
            	    									
            	    pushFollow(FOLLOW_51);
            	    lv_produces_17_0=ruleDataValue();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getEnvironmentalComponentRule());
            	    										}
            	    										add(
            	    											current,
            	    											"produces",
            	    											lv_produces_17_0,
            	    											"ac.at.tuwien.big.Scml.DataValue");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalScml.g:2327:8: (otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) ) )*
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==15) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // InternalScml.g:2328:9: otherlv_18= ',' ( (lv_produces_19_0= ruleDataValue ) )
            	    	    {
            	    	    otherlv_18=(Token)match(input,15,FOLLOW_50); 

            	    	    									newLeafNode(otherlv_18, grammarAccess.getEnvironmentalComponentAccess().getCommaKeyword_3_3_0());
            	    	    								
            	    	    // InternalScml.g:2332:9: ( (lv_produces_19_0= ruleDataValue ) )
            	    	    // InternalScml.g:2333:10: (lv_produces_19_0= ruleDataValue )
            	    	    {
            	    	    // InternalScml.g:2333:10: (lv_produces_19_0= ruleDataValue )
            	    	    // InternalScml.g:2334:11: lv_produces_19_0= ruleDataValue
            	    	    {

            	    	    											newCompositeNode(grammarAccess.getEnvironmentalComponentAccess().getProducesDataValueParserRuleCall_3_3_1_0());
            	    	    										
            	    	    pushFollow(FOLLOW_51);
            	    	    lv_produces_19_0=ruleDataValue();

            	    	    state._fsp--;


            	    	    											if (current==null) {
            	    	    												current = createModelElementForParent(grammarAccess.getEnvironmentalComponentRule());
            	    	    											}
            	    	    											add(
            	    	    												current,
            	    	    												"produces",
            	    	    												lv_produces_19_0,
            	    	    												"ac.at.tuwien.big.Scml.DataValue");
            	    	    											afterParserOrEnumRuleCall();
            	    	    										

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop41;
            	        }
            	    } while (true);

            	    otherlv_20=(Token)match(input,18,FOLLOW_57); 

            	    								newLeafNode(otherlv_20, grammarAccess.getEnvironmentalComponentAccess().getRightCurlyBracketKeyword_3_4());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalScml.g:2362:3: ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) )
            	    {
            	    // InternalScml.g:2362:3: ({...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) ) )
            	    // InternalScml.g:2363:4: {...}? => ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalScml.g:2363:116: ( ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) ) )
            	    // InternalScml.g:2364:5: ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalScml.g:2367:8: ({...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) ) )
            	    // InternalScml.g:2367:9: {...}? => (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "true");
            	    }
            	    // InternalScml.g:2367:18: (otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) ) )
            	    // InternalScml.g:2367:19: otherlv_21= 'environmentalComponentParameter' ( (lv_parameter_22_0= ruleParameter ) )
            	    {
            	    otherlv_21=(Token)match(input,64,FOLLOW_52); 

            	    								newLeafNode(otherlv_21, grammarAccess.getEnvironmentalComponentAccess().getEnvironmentalComponentParameterKeyword_4_0());
            	    							
            	    // InternalScml.g:2371:8: ( (lv_parameter_22_0= ruleParameter ) )
            	    // InternalScml.g:2372:9: (lv_parameter_22_0= ruleParameter )
            	    {
            	    // InternalScml.g:2372:9: (lv_parameter_22_0= ruleParameter )
            	    // InternalScml.g:2373:10: lv_parameter_22_0= ruleParameter
            	    {

            	    										newCompositeNode(grammarAccess.getEnvironmentalComponentAccess().getParameterParameterParserRuleCall_4_1_0());
            	    									
            	    pushFollow(FOLLOW_57);
            	    lv_parameter_22_0=ruleParameter();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getEnvironmentalComponentRule());
            	    										}
            	    										set(
            	    											current,
            	    											"parameter",
            	    											lv_parameter_22_0,
            	    											"ac.at.tuwien.big.Scml.Parameter");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalScml.g:2396:3: ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) )
            	    {
            	    // InternalScml.g:2396:3: ({...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) ) )
            	    // InternalScml.g:2397:4: {...}? => ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "getUnorderedGroupHelper().canSelect(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 5)");
            	    }
            	    // InternalScml.g:2397:116: ( ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) ) )
            	    // InternalScml.g:2398:5: ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup(), 5);
            	    				
            	    // InternalScml.g:2401:8: ({...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' ) )
            	    // InternalScml.g:2401:9: {...}? => ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "true");
            	    }
            	    // InternalScml.g:2401:18: ( (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}' )
            	    // InternalScml.g:2401:19: (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )? otherlv_29= '}'
            	    {
            	    // InternalScml.g:2401:19: (otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']' )?
            	    int alt43=2;
            	    int LA43_0 = input.LA(1);

            	    if ( (LA43_0==65) ) {
            	        alt43=1;
            	    }
            	    switch (alt43) {
            	        case 1 :
            	            // InternalScml.g:2402:9: otherlv_23= 'environmentalComponentDevices' otherlv_24= '[' ( (lv_device_25_0= ruleDevice ) ) (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )* otherlv_28= ']'
            	            {
            	            otherlv_23=(Token)match(input,65,FOLLOW_6); 

            	            									newLeafNode(otherlv_23, grammarAccess.getEnvironmentalComponentAccess().getEnvironmentalComponentDevicesKeyword_5_0_0());
            	            								
            	            otherlv_24=(Token)match(input,14,FOLLOW_53); 

            	            									newLeafNode(otherlv_24, grammarAccess.getEnvironmentalComponentAccess().getLeftSquareBracketKeyword_5_0_1());
            	            								
            	            // InternalScml.g:2410:9: ( (lv_device_25_0= ruleDevice ) )
            	            // InternalScml.g:2411:10: (lv_device_25_0= ruleDevice )
            	            {
            	            // InternalScml.g:2411:10: (lv_device_25_0= ruleDevice )
            	            // InternalScml.g:2412:11: lv_device_25_0= ruleDevice
            	            {

            	            											newCompositeNode(grammarAccess.getEnvironmentalComponentAccess().getDeviceDeviceParserRuleCall_5_0_2_0());
            	            										
            	            pushFollow(FOLLOW_7);
            	            lv_device_25_0=ruleDevice();

            	            state._fsp--;


            	            											if (current==null) {
            	            												current = createModelElementForParent(grammarAccess.getEnvironmentalComponentRule());
            	            											}
            	            											add(
            	            												current,
            	            												"device",
            	            												lv_device_25_0,
            	            												"ac.at.tuwien.big.Scml.Device");
            	            											afterParserOrEnumRuleCall();
            	            										

            	            }


            	            }

            	            // InternalScml.g:2429:9: (otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) ) )*
            	            loop42:
            	            do {
            	                int alt42=2;
            	                int LA42_0 = input.LA(1);

            	                if ( (LA42_0==15) ) {
            	                    alt42=1;
            	                }


            	                switch (alt42) {
            	            	case 1 :
            	            	    // InternalScml.g:2430:10: otherlv_26= ',' ( (lv_device_27_0= ruleDevice ) )
            	            	    {
            	            	    otherlv_26=(Token)match(input,15,FOLLOW_53); 

            	            	    										newLeafNode(otherlv_26, grammarAccess.getEnvironmentalComponentAccess().getCommaKeyword_5_0_3_0());
            	            	    									
            	            	    // InternalScml.g:2434:10: ( (lv_device_27_0= ruleDevice ) )
            	            	    // InternalScml.g:2435:11: (lv_device_27_0= ruleDevice )
            	            	    {
            	            	    // InternalScml.g:2435:11: (lv_device_27_0= ruleDevice )
            	            	    // InternalScml.g:2436:12: lv_device_27_0= ruleDevice
            	            	    {

            	            	    												newCompositeNode(grammarAccess.getEnvironmentalComponentAccess().getDeviceDeviceParserRuleCall_5_0_3_1_0());
            	            	    											
            	            	    pushFollow(FOLLOW_7);
            	            	    lv_device_27_0=ruleDevice();

            	            	    state._fsp--;


            	            	    												if (current==null) {
            	            	    													current = createModelElementForParent(grammarAccess.getEnvironmentalComponentRule());
            	            	    												}
            	            	    												add(
            	            	    													current,
            	            	    													"device",
            	            	    													lv_device_27_0,
            	            	    													"ac.at.tuwien.big.Scml.Device");
            	            	    												afterParserOrEnumRuleCall();
            	            	    											

            	            	    }


            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop42;
            	                }
            	            } while (true);

            	            otherlv_28=(Token)match(input,16,FOLLOW_10); 

            	            									newLeafNode(otherlv_28, grammarAccess.getEnvironmentalComponentAccess().getRightSquareBracketKeyword_5_0_4());
            	            								

            	            }
            	            break;

            	    }

            	    otherlv_29=(Token)match(input,18,FOLLOW_57); 

            	    								newLeafNode(otherlv_29, grammarAccess.getEnvironmentalComponentAccess().getRightCurlyBracketKeyword_5_1());
            	    							

            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt44 >= 1 ) break loop44;
                        EarlyExitException eee =
                            new EarlyExitException(44, input);
                        throw eee;
                }
                cnt44++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleEnvironmentalComponent", "getUnorderedGroupHelper().canLeave(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getEnvironmentalComponentAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnvironmentalComponent"


    // $ANTLR start "entryRuleEFloat"
    // InternalScml.g:2480:1: entryRuleEFloat returns [String current=null] : iv_ruleEFloat= ruleEFloat EOF ;
    public final String entryRuleEFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEFloat = null;


        try {
            // InternalScml.g:2480:46: (iv_ruleEFloat= ruleEFloat EOF )
            // InternalScml.g:2481:2: iv_ruleEFloat= ruleEFloat EOF
            {
             newCompositeNode(grammarAccess.getEFloatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEFloat=ruleEFloat();

            state._fsp--;

             current =iv_ruleEFloat.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEFloat"


    // $ANTLR start "ruleEFloat"
    // InternalScml.g:2487:1: ruleEFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalScml.g:2493:2: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // InternalScml.g:2494:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // InternalScml.g:2494:2: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // InternalScml.g:2495:3: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // InternalScml.g:2495:3: (kw= '-' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==26) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalScml.g:2496:4: kw= '-'
                    {
                    kw=(Token)match(input,26,FOLLOW_58); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getEFloatAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            // InternalScml.g:2502:3: (this_INT_1= RULE_INT )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_INT) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalScml.g:2503:4: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FOLLOW_59); 

                    				current.merge(this_INT_1);
                    			

                    				newLeafNode(this_INT_1, grammarAccess.getEFloatAccess().getINTTerminalRuleCall_1());
                    			

                    }
                    break;

            }

            kw=(Token)match(input,66,FOLLOW_23); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getEFloatAccess().getFullStopKeyword_2());
            		
            this_INT_3=(Token)match(input,RULE_INT,FOLLOW_60); 

            			current.merge(this_INT_3);
            		

            			newLeafNode(this_INT_3, grammarAccess.getEFloatAccess().getINTTerminalRuleCall_3());
            		
            // InternalScml.g:2523:3: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=67 && LA49_0<=68)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalScml.g:2524:4: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // InternalScml.g:2524:4: (kw= 'E' | kw= 'e' )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==67) ) {
                        alt47=1;
                    }
                    else if ( (LA47_0==68) ) {
                        alt47=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 0, input);

                        throw nvae;
                    }
                    switch (alt47) {
                        case 1 :
                            // InternalScml.g:2525:5: kw= 'E'
                            {
                            kw=(Token)match(input,67,FOLLOW_14); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEFloatAccess().getEKeyword_4_0_0());
                            				

                            }
                            break;
                        case 2 :
                            // InternalScml.g:2531:5: kw= 'e'
                            {
                            kw=(Token)match(input,68,FOLLOW_14); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEFloatAccess().getEKeyword_4_0_1());
                            				

                            }
                            break;

                    }

                    // InternalScml.g:2537:4: (kw= '-' )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==26) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // InternalScml.g:2538:5: kw= '-'
                            {
                            kw=(Token)match(input,26,FOLLOW_23); 

                            					current.merge(kw);
                            					newLeafNode(kw, grammarAccess.getEFloatAccess().getHyphenMinusKeyword_4_1());
                            				

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_7);
                    			

                    				newLeafNode(this_INT_7, grammarAccess.getEFloatAccess().getINTTerminalRuleCall_4_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEFloat"


    // $ANTLR start "entryRuleGoalReferenceValue"
    // InternalScml.g:2556:1: entryRuleGoalReferenceValue returns [EObject current=null] : iv_ruleGoalReferenceValue= ruleGoalReferenceValue EOF ;
    public final EObject entryRuleGoalReferenceValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalReferenceValue = null;


        try {
            // InternalScml.g:2556:59: (iv_ruleGoalReferenceValue= ruleGoalReferenceValue EOF )
            // InternalScml.g:2557:2: iv_ruleGoalReferenceValue= ruleGoalReferenceValue EOF
            {
             newCompositeNode(grammarAccess.getGoalReferenceValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGoalReferenceValue=ruleGoalReferenceValue();

            state._fsp--;

             current =iv_ruleGoalReferenceValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGoalReferenceValue"


    // $ANTLR start "ruleGoalReferenceValue"
    // InternalScml.g:2563:1: ruleGoalReferenceValue returns [EObject current=null] : (otherlv_0= 'GoalValue' otherlv_1= '(' otherlv_2= 'value' otherlv_3= '=' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= 'type' otherlv_7= '=' ( (lv_type_8_0= ruleDataType ) ) otherlv_9= ')' (otherlv_10= 'basedOn' otherlv_11= '->' ( (lv_basis_12_0= ruleBasis ) ) )? ) ;
    public final EObject ruleGoalReferenceValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_value_4_0 = null;

        Enumerator lv_type_8_0 = null;

        EObject lv_basis_12_0 = null;



        	enterRule();

        try {
            // InternalScml.g:2569:2: ( (otherlv_0= 'GoalValue' otherlv_1= '(' otherlv_2= 'value' otherlv_3= '=' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= 'type' otherlv_7= '=' ( (lv_type_8_0= ruleDataType ) ) otherlv_9= ')' (otherlv_10= 'basedOn' otherlv_11= '->' ( (lv_basis_12_0= ruleBasis ) ) )? ) )
            // InternalScml.g:2570:2: (otherlv_0= 'GoalValue' otherlv_1= '(' otherlv_2= 'value' otherlv_3= '=' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= 'type' otherlv_7= '=' ( (lv_type_8_0= ruleDataType ) ) otherlv_9= ')' (otherlv_10= 'basedOn' otherlv_11= '->' ( (lv_basis_12_0= ruleBasis ) ) )? )
            {
            // InternalScml.g:2570:2: (otherlv_0= 'GoalValue' otherlv_1= '(' otherlv_2= 'value' otherlv_3= '=' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= 'type' otherlv_7= '=' ( (lv_type_8_0= ruleDataType ) ) otherlv_9= ')' (otherlv_10= 'basedOn' otherlv_11= '->' ( (lv_basis_12_0= ruleBasis ) ) )? )
            // InternalScml.g:2571:3: otherlv_0= 'GoalValue' otherlv_1= '(' otherlv_2= 'value' otherlv_3= '=' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= 'type' otherlv_7= '=' ( (lv_type_8_0= ruleDataType ) ) otherlv_9= ')' (otherlv_10= 'basedOn' otherlv_11= '->' ( (lv_basis_12_0= ruleBasis ) ) )?
            {
            otherlv_0=(Token)match(input,69,FOLLOW_17); 

            			newLeafNode(otherlv_0, grammarAccess.getGoalReferenceValueAccess().getGoalValueKeyword_0());
            		
            otherlv_1=(Token)match(input,19,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getGoalReferenceValueAccess().getLeftParenthesisKeyword_1());
            		
            otherlv_2=(Token)match(input,36,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getGoalReferenceValueAccess().getValueKeyword_2());
            		
            otherlv_3=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getGoalReferenceValueAccess().getEqualsSignKeyword_3());
            		
            // InternalScml.g:2587:3: ( (lv_value_4_0= ruleEString ) )
            // InternalScml.g:2588:4: (lv_value_4_0= ruleEString )
            {
            // InternalScml.g:2588:4: (lv_value_4_0= ruleEString )
            // InternalScml.g:2589:5: lv_value_4_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getGoalReferenceValueAccess().getValueEStringParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_32);
            lv_value_4_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGoalReferenceValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_4_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,15,FOLLOW_41); 

            			newLeafNode(otherlv_5, grammarAccess.getGoalReferenceValueAccess().getCommaKeyword_5());
            		
            otherlv_6=(Token)match(input,40,FOLLOW_13); 

            			newLeafNode(otherlv_6, grammarAccess.getGoalReferenceValueAccess().getTypeKeyword_6());
            		
            otherlv_7=(Token)match(input,21,FOLLOW_36); 

            			newLeafNode(otherlv_7, grammarAccess.getGoalReferenceValueAccess().getEqualsSignKeyword_7());
            		
            // InternalScml.g:2618:3: ( (lv_type_8_0= ruleDataType ) )
            // InternalScml.g:2619:4: (lv_type_8_0= ruleDataType )
            {
            // InternalScml.g:2619:4: (lv_type_8_0= ruleDataType )
            // InternalScml.g:2620:5: lv_type_8_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getGoalReferenceValueAccess().getTypeDataTypeEnumRuleCall_8_0());
            				
            pushFollow(FOLLOW_28);
            lv_type_8_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGoalReferenceValueRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_8_0,
            						"ac.at.tuwien.big.Scml.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_9=(Token)match(input,22,FOLLOW_61); 

            			newLeafNode(otherlv_9, grammarAccess.getGoalReferenceValueAccess().getRightParenthesisKeyword_9());
            		
            // InternalScml.g:2641:3: (otherlv_10= 'basedOn' otherlv_11= '->' ( (lv_basis_12_0= ruleBasis ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==70) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalScml.g:2642:4: otherlv_10= 'basedOn' otherlv_11= '->' ( (lv_basis_12_0= ruleBasis ) )
                    {
                    otherlv_10=(Token)match(input,70,FOLLOW_62); 

                    				newLeafNode(otherlv_10, grammarAccess.getGoalReferenceValueAccess().getBasedOnKeyword_10_0());
                    			
                    otherlv_11=(Token)match(input,71,FOLLOW_63); 

                    				newLeafNode(otherlv_11, grammarAccess.getGoalReferenceValueAccess().getHyphenMinusGreaterThanSignKeyword_10_1());
                    			
                    // InternalScml.g:2650:4: ( (lv_basis_12_0= ruleBasis ) )
                    // InternalScml.g:2651:5: (lv_basis_12_0= ruleBasis )
                    {
                    // InternalScml.g:2651:5: (lv_basis_12_0= ruleBasis )
                    // InternalScml.g:2652:6: lv_basis_12_0= ruleBasis
                    {

                    						newCompositeNode(grammarAccess.getGoalReferenceValueAccess().getBasisBasisParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_basis_12_0=ruleBasis();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGoalReferenceValueRule());
                    						}
                    						set(
                    							current,
                    							"basis",
                    							lv_basis_12_0,
                    							"ac.at.tuwien.big.Scml.Basis");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGoalReferenceValue"


    // $ANTLR start "entryRuleAggregatedValue"
    // InternalScml.g:2674:1: entryRuleAggregatedValue returns [EObject current=null] : iv_ruleAggregatedValue= ruleAggregatedValue EOF ;
    public final EObject entryRuleAggregatedValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAggregatedValue = null;


        try {
            // InternalScml.g:2674:56: (iv_ruleAggregatedValue= ruleAggregatedValue EOF )
            // InternalScml.g:2675:2: iv_ruleAggregatedValue= ruleAggregatedValue EOF
            {
             newCompositeNode(grammarAccess.getAggregatedValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAggregatedValue=ruleAggregatedValue();

            state._fsp--;

             current =iv_ruleAggregatedValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAggregatedValue"


    // $ANTLR start "ruleAggregatedValue"
    // InternalScml.g:2681:1: ruleAggregatedValue returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'value' otherlv_2= ':' ( (lv_value_3_0= ruleEString ) ) otherlv_4= 'type' otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'aggregatorType' otherlv_8= ':' ( (lv_aggregator_9_0= ruleOperation ) ) (otherlv_10= 'aggregatedTime' otherlv_11= ':' ( (lv_aggregatedTime_12_0= ruleEString ) ) )? otherlv_13= '}' ) ;
    public final EObject ruleAggregatedValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;

        Enumerator lv_type_6_0 = null;

        Enumerator lv_aggregator_9_0 = null;

        AntlrDatatypeRuleToken lv_aggregatedTime_12_0 = null;



        	enterRule();

        try {
            // InternalScml.g:2687:2: ( (otherlv_0= '{' otherlv_1= 'value' otherlv_2= ':' ( (lv_value_3_0= ruleEString ) ) otherlv_4= 'type' otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'aggregatorType' otherlv_8= ':' ( (lv_aggregator_9_0= ruleOperation ) ) (otherlv_10= 'aggregatedTime' otherlv_11= ':' ( (lv_aggregatedTime_12_0= ruleEString ) ) )? otherlv_13= '}' ) )
            // InternalScml.g:2688:2: (otherlv_0= '{' otherlv_1= 'value' otherlv_2= ':' ( (lv_value_3_0= ruleEString ) ) otherlv_4= 'type' otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'aggregatorType' otherlv_8= ':' ( (lv_aggregator_9_0= ruleOperation ) ) (otherlv_10= 'aggregatedTime' otherlv_11= ':' ( (lv_aggregatedTime_12_0= ruleEString ) ) )? otherlv_13= '}' )
            {
            // InternalScml.g:2688:2: (otherlv_0= '{' otherlv_1= 'value' otherlv_2= ':' ( (lv_value_3_0= ruleEString ) ) otherlv_4= 'type' otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'aggregatorType' otherlv_8= ':' ( (lv_aggregator_9_0= ruleOperation ) ) (otherlv_10= 'aggregatedTime' otherlv_11= ':' ( (lv_aggregatedTime_12_0= ruleEString ) ) )? otherlv_13= '}' )
            // InternalScml.g:2689:3: otherlv_0= '{' otherlv_1= 'value' otherlv_2= ':' ( (lv_value_3_0= ruleEString ) ) otherlv_4= 'type' otherlv_5= ':' ( (lv_type_6_0= ruleDataType ) ) otherlv_7= 'aggregatorType' otherlv_8= ':' ( (lv_aggregator_9_0= ruleOperation ) ) (otherlv_10= 'aggregatedTime' otherlv_11= ':' ( (lv_aggregatedTime_12_0= ruleEString ) ) )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getAggregatedValueAccess().getLeftCurlyBracketKeyword_0());
            		
            otherlv_1=(Token)match(input,36,FOLLOW_44); 

            			newLeafNode(otherlv_1, grammarAccess.getAggregatedValueAccess().getValueKeyword_1());
            		
            otherlv_2=(Token)match(input,42,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getAggregatedValueAccess().getColonKeyword_2());
            		
            // InternalScml.g:2701:3: ( (lv_value_3_0= ruleEString ) )
            // InternalScml.g:2702:4: (lv_value_3_0= ruleEString )
            {
            // InternalScml.g:2702:4: (lv_value_3_0= ruleEString )
            // InternalScml.g:2703:5: lv_value_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getAggregatedValueAccess().getValueEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_41);
            lv_value_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAggregatedValueRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,40,FOLLOW_44); 

            			newLeafNode(otherlv_4, grammarAccess.getAggregatedValueAccess().getTypeKeyword_4());
            		
            otherlv_5=(Token)match(input,42,FOLLOW_36); 

            			newLeafNode(otherlv_5, grammarAccess.getAggregatedValueAccess().getColonKeyword_5());
            		
            // InternalScml.g:2728:3: ( (lv_type_6_0= ruleDataType ) )
            // InternalScml.g:2729:4: (lv_type_6_0= ruleDataType )
            {
            // InternalScml.g:2729:4: (lv_type_6_0= ruleDataType )
            // InternalScml.g:2730:5: lv_type_6_0= ruleDataType
            {

            					newCompositeNode(grammarAccess.getAggregatedValueAccess().getTypeDataTypeEnumRuleCall_6_0());
            				
            pushFollow(FOLLOW_64);
            lv_type_6_0=ruleDataType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAggregatedValueRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_6_0,
            						"ac.at.tuwien.big.Scml.DataType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,72,FOLLOW_44); 

            			newLeafNode(otherlv_7, grammarAccess.getAggregatedValueAccess().getAggregatorTypeKeyword_7());
            		
            otherlv_8=(Token)match(input,42,FOLLOW_65); 

            			newLeafNode(otherlv_8, grammarAccess.getAggregatedValueAccess().getColonKeyword_8());
            		
            // InternalScml.g:2755:3: ( (lv_aggregator_9_0= ruleOperation ) )
            // InternalScml.g:2756:4: (lv_aggregator_9_0= ruleOperation )
            {
            // InternalScml.g:2756:4: (lv_aggregator_9_0= ruleOperation )
            // InternalScml.g:2757:5: lv_aggregator_9_0= ruleOperation
            {

            					newCompositeNode(grammarAccess.getAggregatedValueAccess().getAggregatorOperationEnumRuleCall_9_0());
            				
            pushFollow(FOLLOW_66);
            lv_aggregator_9_0=ruleOperation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAggregatedValueRule());
            					}
            					set(
            						current,
            						"aggregator",
            						lv_aggregator_9_0,
            						"ac.at.tuwien.big.Scml.Operation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalScml.g:2774:3: (otherlv_10= 'aggregatedTime' otherlv_11= ':' ( (lv_aggregatedTime_12_0= ruleEString ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==73) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalScml.g:2775:4: otherlv_10= 'aggregatedTime' otherlv_11= ':' ( (lv_aggregatedTime_12_0= ruleEString ) )
                    {
                    otherlv_10=(Token)match(input,73,FOLLOW_44); 

                    				newLeafNode(otherlv_10, grammarAccess.getAggregatedValueAccess().getAggregatedTimeKeyword_10_0());
                    			
                    otherlv_11=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_11, grammarAccess.getAggregatedValueAccess().getColonKeyword_10_1());
                    			
                    // InternalScml.g:2783:4: ( (lv_aggregatedTime_12_0= ruleEString ) )
                    // InternalScml.g:2784:5: (lv_aggregatedTime_12_0= ruleEString )
                    {
                    // InternalScml.g:2784:5: (lv_aggregatedTime_12_0= ruleEString )
                    // InternalScml.g:2785:6: lv_aggregatedTime_12_0= ruleEString
                    {

                    						newCompositeNode(grammarAccess.getAggregatedValueAccess().getAggregatedTimeEStringParserRuleCall_10_2_0());
                    					
                    pushFollow(FOLLOW_10);
                    lv_aggregatedTime_12_0=ruleEString();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAggregatedValueRule());
                    						}
                    						set(
                    							current,
                    							"aggregatedTime",
                    							lv_aggregatedTime_12_0,
                    							"ac.at.tuwien.big.Scml.EString");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_13=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getAggregatedValueAccess().getRightCurlyBracketKeyword_11());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAggregatedValue"


    // $ANTLR start "entryRuleBasis"
    // InternalScml.g:2811:1: entryRuleBasis returns [EObject current=null] : iv_ruleBasis= ruleBasis EOF ;
    public final EObject entryRuleBasis() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasis = null;


        try {
            // InternalScml.g:2811:46: (iv_ruleBasis= ruleBasis EOF )
            // InternalScml.g:2812:2: iv_ruleBasis= ruleBasis EOF
            {
             newCompositeNode(grammarAccess.getBasisRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBasis=ruleBasis();

            state._fsp--;

             current =iv_ruleBasis; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBasis"


    // $ANTLR start "ruleBasis"
    // InternalScml.g:2818:1: ruleBasis returns [EObject current=null] : (otherlv_0= 'Basis' otherlv_1= '{' otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) otherlv_4= 'principleType' ( (lv_principleType_5_0= rulePrincipleType ) ) otherlv_6= 'source' ( (lv_source_7_0= ruleEString ) ) otherlv_8= '}' ) ;
    public final EObject ruleBasis() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_description_3_0 = null;

        Enumerator lv_principleType_5_0 = null;

        AntlrDatatypeRuleToken lv_source_7_0 = null;



        	enterRule();

        try {
            // InternalScml.g:2824:2: ( (otherlv_0= 'Basis' otherlv_1= '{' otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) otherlv_4= 'principleType' ( (lv_principleType_5_0= rulePrincipleType ) ) otherlv_6= 'source' ( (lv_source_7_0= ruleEString ) ) otherlv_8= '}' ) )
            // InternalScml.g:2825:2: (otherlv_0= 'Basis' otherlv_1= '{' otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) otherlv_4= 'principleType' ( (lv_principleType_5_0= rulePrincipleType ) ) otherlv_6= 'source' ( (lv_source_7_0= ruleEString ) ) otherlv_8= '}' )
            {
            // InternalScml.g:2825:2: (otherlv_0= 'Basis' otherlv_1= '{' otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) otherlv_4= 'principleType' ( (lv_principleType_5_0= rulePrincipleType ) ) otherlv_6= 'source' ( (lv_source_7_0= ruleEString ) ) otherlv_8= '}' )
            // InternalScml.g:2826:3: otherlv_0= 'Basis' otherlv_1= '{' otherlv_2= 'description' ( (lv_description_3_0= ruleEString ) ) otherlv_4= 'principleType' ( (lv_principleType_5_0= rulePrincipleType ) ) otherlv_6= 'source' ( (lv_source_7_0= ruleEString ) ) otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getBasisAccess().getBasisKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_67); 

            			newLeafNode(otherlv_1, grammarAccess.getBasisAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,75,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getBasisAccess().getDescriptionKeyword_2());
            		
            // InternalScml.g:2838:3: ( (lv_description_3_0= ruleEString ) )
            // InternalScml.g:2839:4: (lv_description_3_0= ruleEString )
            {
            // InternalScml.g:2839:4: (lv_description_3_0= ruleEString )
            // InternalScml.g:2840:5: lv_description_3_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getBasisAccess().getDescriptionEStringParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_68);
            lv_description_3_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBasisRule());
            					}
            					set(
            						current,
            						"description",
            						lv_description_3_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,76,FOLLOW_69); 

            			newLeafNode(otherlv_4, grammarAccess.getBasisAccess().getPrincipleTypeKeyword_4());
            		
            // InternalScml.g:2861:3: ( (lv_principleType_5_0= rulePrincipleType ) )
            // InternalScml.g:2862:4: (lv_principleType_5_0= rulePrincipleType )
            {
            // InternalScml.g:2862:4: (lv_principleType_5_0= rulePrincipleType )
            // InternalScml.g:2863:5: lv_principleType_5_0= rulePrincipleType
            {

            					newCompositeNode(grammarAccess.getBasisAccess().getPrincipleTypePrincipleTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_70);
            lv_principleType_5_0=rulePrincipleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBasisRule());
            					}
            					set(
            						current,
            						"principleType",
            						lv_principleType_5_0,
            						"ac.at.tuwien.big.Scml.PrincipleType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,77,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getBasisAccess().getSourceKeyword_6());
            		
            // InternalScml.g:2884:3: ( (lv_source_7_0= ruleEString ) )
            // InternalScml.g:2885:4: (lv_source_7_0= ruleEString )
            {
            // InternalScml.g:2885:4: (lv_source_7_0= ruleEString )
            // InternalScml.g:2886:5: lv_source_7_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getBasisAccess().getSourceEStringParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_10);
            lv_source_7_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBasisRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_7_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getBasisAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBasis"


    // $ANTLR start "entryRuleSensor"
    // InternalScml.g:2911:1: entryRuleSensor returns [EObject current=null] : iv_ruleSensor= ruleSensor EOF ;
    public final EObject entryRuleSensor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSensor = null;


        try {
            // InternalScml.g:2911:47: (iv_ruleSensor= ruleSensor EOF )
            // InternalScml.g:2912:2: iv_ruleSensor= ruleSensor EOF
            {
             newCompositeNode(grammarAccess.getSensorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSensor=ruleSensor();

            state._fsp--;

             current =iv_ruleSensor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSensor"


    // $ANTLR start "ruleSensor"
    // InternalScml.g:2918:1: ruleSensor returns [EObject current=null] : (otherlv_0= 'Sensor' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')' ) ;
    public final EObject ruleSensor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalScml.g:2924:2: ( (otherlv_0= 'Sensor' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')' ) )
            // InternalScml.g:2925:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')' )
            {
            // InternalScml.g:2925:2: (otherlv_0= 'Sensor' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')' )
            // InternalScml.g:2926:3: otherlv_0= 'Sensor' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSensorAccess().getSensorKeyword_0());
            		
            // InternalScml.g:2930:3: ( (lv_name_1_0= ruleEString ) )
            // InternalScml.g:2931:4: (lv_name_1_0= ruleEString )
            {
            // InternalScml.g:2931:4: (lv_name_1_0= ruleEString )
            // InternalScml.g:2932:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getSensorAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_17);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSensorRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getSensorAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,40,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getSensorAccess().getTypeKeyword_3());
            		
            otherlv_4=(Token)match(input,21,FOLLOW_42); 

            			newLeafNode(otherlv_4, grammarAccess.getSensorAccess().getEqualsSignKeyword_4());
            		
            // InternalScml.g:2961:3: ( (lv_type_5_0= ruleParameterType ) )
            // InternalScml.g:2962:4: (lv_type_5_0= ruleParameterType )
            {
            // InternalScml.g:2962:4: (lv_type_5_0= ruleParameterType )
            // InternalScml.g:2963:5: lv_type_5_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getSensorAccess().getTypeParameterTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_28);
            lv_type_5_0=ruleParameterType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSensorRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_5_0,
            						"ac.at.tuwien.big.Scml.ParameterType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getSensorAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSensor"


    // $ANTLR start "entryRuleActuator"
    // InternalScml.g:2988:1: entryRuleActuator returns [EObject current=null] : iv_ruleActuator= ruleActuator EOF ;
    public final EObject entryRuleActuator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActuator = null;


        try {
            // InternalScml.g:2988:49: (iv_ruleActuator= ruleActuator EOF )
            // InternalScml.g:2989:2: iv_ruleActuator= ruleActuator EOF
            {
             newCompositeNode(grammarAccess.getActuatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActuator=ruleActuator();

            state._fsp--;

             current =iv_ruleActuator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActuator"


    // $ANTLR start "ruleActuator"
    // InternalScml.g:2995:1: ruleActuator returns [EObject current=null] : (otherlv_0= 'Actuator' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')' ) ;
    public final EObject ruleActuator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        Enumerator lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalScml.g:3001:2: ( (otherlv_0= 'Actuator' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')' ) )
            // InternalScml.g:3002:2: (otherlv_0= 'Actuator' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')' )
            {
            // InternalScml.g:3002:2: (otherlv_0= 'Actuator' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')' )
            // InternalScml.g:3003:3: otherlv_0= 'Actuator' ( (lv_name_1_0= ruleEString ) ) otherlv_2= '(' otherlv_3= 'type' otherlv_4= '=' ( (lv_type_5_0= ruleParameterType ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,79,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActuatorAccess().getActuatorKeyword_0());
            		
            // InternalScml.g:3007:3: ( (lv_name_1_0= ruleEString ) )
            // InternalScml.g:3008:4: (lv_name_1_0= ruleEString )
            {
            // InternalScml.g:3008:4: (lv_name_1_0= ruleEString )
            // InternalScml.g:3009:5: lv_name_1_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getActuatorAccess().getNameEStringParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_17);
            lv_name_1_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActuatorRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"ac.at.tuwien.big.Scml.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_41); 

            			newLeafNode(otherlv_2, grammarAccess.getActuatorAccess().getLeftParenthesisKeyword_2());
            		
            otherlv_3=(Token)match(input,40,FOLLOW_13); 

            			newLeafNode(otherlv_3, grammarAccess.getActuatorAccess().getTypeKeyword_3());
            		
            otherlv_4=(Token)match(input,21,FOLLOW_42); 

            			newLeafNode(otherlv_4, grammarAccess.getActuatorAccess().getEqualsSignKeyword_4());
            		
            // InternalScml.g:3038:3: ( (lv_type_5_0= ruleParameterType ) )
            // InternalScml.g:3039:4: (lv_type_5_0= ruleParameterType )
            {
            // InternalScml.g:3039:4: (lv_type_5_0= ruleParameterType )
            // InternalScml.g:3040:5: lv_type_5_0= ruleParameterType
            {

            					newCompositeNode(grammarAccess.getActuatorAccess().getTypeParameterTypeEnumRuleCall_5_0());
            				
            pushFollow(FOLLOW_28);
            lv_type_5_0=ruleParameterType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActuatorRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_5_0,
            						"ac.at.tuwien.big.Scml.ParameterType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getActuatorAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActuator"


    // $ANTLR start "ruleDataType"
    // InternalScml.g:3065:1: ruleDataType returns [Enumerator current=null] : ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'BOOL' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) ) ;
    public final Enumerator ruleDataType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalScml.g:3071:2: ( ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'BOOL' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) ) )
            // InternalScml.g:3072:2: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'BOOL' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) )
            {
            // InternalScml.g:3072:2: ( (enumLiteral_0= 'STRING' ) | (enumLiteral_1= 'BOOL' ) | (enumLiteral_2= 'INTEGER' ) | (enumLiteral_3= 'FLOAT' ) )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt52=1;
                }
                break;
            case 81:
                {
                alt52=2;
                }
                break;
            case 82:
                {
                alt52=3;
                }
                break;
            case 83:
                {
                alt52=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalScml.g:3073:3: (enumLiteral_0= 'STRING' )
                    {
                    // InternalScml.g:3073:3: (enumLiteral_0= 'STRING' )
                    // InternalScml.g:3074:4: enumLiteral_0= 'STRING'
                    {
                    enumLiteral_0=(Token)match(input,80,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDataTypeAccess().getSTRINGEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalScml.g:3081:3: (enumLiteral_1= 'BOOL' )
                    {
                    // InternalScml.g:3081:3: (enumLiteral_1= 'BOOL' )
                    // InternalScml.g:3082:4: enumLiteral_1= 'BOOL'
                    {
                    enumLiteral_1=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getBOOLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDataTypeAccess().getBOOLEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalScml.g:3089:3: (enumLiteral_2= 'INTEGER' )
                    {
                    // InternalScml.g:3089:3: (enumLiteral_2= 'INTEGER' )
                    // InternalScml.g:3090:4: enumLiteral_2= 'INTEGER'
                    {
                    enumLiteral_2=(Token)match(input,82,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDataTypeAccess().getINTEGEREnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalScml.g:3097:3: (enumLiteral_3= 'FLOAT' )
                    {
                    // InternalScml.g:3097:3: (enumLiteral_3= 'FLOAT' )
                    // InternalScml.g:3098:4: enumLiteral_3= 'FLOAT'
                    {
                    enumLiteral_3=(Token)match(input,83,FOLLOW_2); 

                    				current = grammarAccess.getDataTypeAccess().getFLOATEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getDataTypeAccess().getFLOATEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDataType"


    // $ANTLR start "ruleParameterType"
    // InternalScml.g:3108:1: ruleParameterType returns [Enumerator current=null] : ( (enumLiteral_0= 'AIRQUALITY' ) | (enumLiteral_1= 'WEATHER' ) | (enumLiteral_2= 'TRAFFIC' ) | (enumLiteral_3= 'ENERGY' ) | (enumLiteral_4= 'AGRICULTURAL' ) | (enumLiteral_5= 'NAVIGATION' ) | (enumLiteral_6= 'WASTEMANAGEMENT' ) | (enumLiteral_7= 'SAFETY' ) ) ;
    public final Enumerator ruleParameterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalScml.g:3114:2: ( ( (enumLiteral_0= 'AIRQUALITY' ) | (enumLiteral_1= 'WEATHER' ) | (enumLiteral_2= 'TRAFFIC' ) | (enumLiteral_3= 'ENERGY' ) | (enumLiteral_4= 'AGRICULTURAL' ) | (enumLiteral_5= 'NAVIGATION' ) | (enumLiteral_6= 'WASTEMANAGEMENT' ) | (enumLiteral_7= 'SAFETY' ) ) )
            // InternalScml.g:3115:2: ( (enumLiteral_0= 'AIRQUALITY' ) | (enumLiteral_1= 'WEATHER' ) | (enumLiteral_2= 'TRAFFIC' ) | (enumLiteral_3= 'ENERGY' ) | (enumLiteral_4= 'AGRICULTURAL' ) | (enumLiteral_5= 'NAVIGATION' ) | (enumLiteral_6= 'WASTEMANAGEMENT' ) | (enumLiteral_7= 'SAFETY' ) )
            {
            // InternalScml.g:3115:2: ( (enumLiteral_0= 'AIRQUALITY' ) | (enumLiteral_1= 'WEATHER' ) | (enumLiteral_2= 'TRAFFIC' ) | (enumLiteral_3= 'ENERGY' ) | (enumLiteral_4= 'AGRICULTURAL' ) | (enumLiteral_5= 'NAVIGATION' ) | (enumLiteral_6= 'WASTEMANAGEMENT' ) | (enumLiteral_7= 'SAFETY' ) )
            int alt53=8;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt53=1;
                }
                break;
            case 85:
                {
                alt53=2;
                }
                break;
            case 86:
                {
                alt53=3;
                }
                break;
            case 87:
                {
                alt53=4;
                }
                break;
            case 88:
                {
                alt53=5;
                }
                break;
            case 89:
                {
                alt53=6;
                }
                break;
            case 90:
                {
                alt53=7;
                }
                break;
            case 91:
                {
                alt53=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalScml.g:3116:3: (enumLiteral_0= 'AIRQUALITY' )
                    {
                    // InternalScml.g:3116:3: (enumLiteral_0= 'AIRQUALITY' )
                    // InternalScml.g:3117:4: enumLiteral_0= 'AIRQUALITY'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getAIRQUALITYEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getParameterTypeAccess().getAIRQUALITYEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalScml.g:3124:3: (enumLiteral_1= 'WEATHER' )
                    {
                    // InternalScml.g:3124:3: (enumLiteral_1= 'WEATHER' )
                    // InternalScml.g:3125:4: enumLiteral_1= 'WEATHER'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getWEATHEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getParameterTypeAccess().getWEATHEREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalScml.g:3132:3: (enumLiteral_2= 'TRAFFIC' )
                    {
                    // InternalScml.g:3132:3: (enumLiteral_2= 'TRAFFIC' )
                    // InternalScml.g:3133:4: enumLiteral_2= 'TRAFFIC'
                    {
                    enumLiteral_2=(Token)match(input,86,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getTRAFFICEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getParameterTypeAccess().getTRAFFICEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalScml.g:3140:3: (enumLiteral_3= 'ENERGY' )
                    {
                    // InternalScml.g:3140:3: (enumLiteral_3= 'ENERGY' )
                    // InternalScml.g:3141:4: enumLiteral_3= 'ENERGY'
                    {
                    enumLiteral_3=(Token)match(input,87,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getENERGYEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getParameterTypeAccess().getENERGYEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalScml.g:3148:3: (enumLiteral_4= 'AGRICULTURAL' )
                    {
                    // InternalScml.g:3148:3: (enumLiteral_4= 'AGRICULTURAL' )
                    // InternalScml.g:3149:4: enumLiteral_4= 'AGRICULTURAL'
                    {
                    enumLiteral_4=(Token)match(input,88,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getAGRICULTURALEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getParameterTypeAccess().getAGRICULTURALEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalScml.g:3156:3: (enumLiteral_5= 'NAVIGATION' )
                    {
                    // InternalScml.g:3156:3: (enumLiteral_5= 'NAVIGATION' )
                    // InternalScml.g:3157:4: enumLiteral_5= 'NAVIGATION'
                    {
                    enumLiteral_5=(Token)match(input,89,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getNAVIGATIONEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getParameterTypeAccess().getNAVIGATIONEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalScml.g:3164:3: (enumLiteral_6= 'WASTEMANAGEMENT' )
                    {
                    // InternalScml.g:3164:3: (enumLiteral_6= 'WASTEMANAGEMENT' )
                    // InternalScml.g:3165:4: enumLiteral_6= 'WASTEMANAGEMENT'
                    {
                    enumLiteral_6=(Token)match(input,90,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getWASTEMANAGEMENTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getParameterTypeAccess().getWASTEMANAGEMENTEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalScml.g:3172:3: (enumLiteral_7= 'SAFETY' )
                    {
                    // InternalScml.g:3172:3: (enumLiteral_7= 'SAFETY' )
                    // InternalScml.g:3173:4: enumLiteral_7= 'SAFETY'
                    {
                    enumLiteral_7=(Token)match(input,91,FOLLOW_2); 

                    				current = grammarAccess.getParameterTypeAccess().getSAFETYEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getParameterTypeAccess().getSAFETYEnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterType"


    // $ANTLR start "rulePrincipleType"
    // InternalScml.g:3183:1: rulePrincipleType returns [Enumerator current=null] : ( (enumLiteral_0= 'LAW' ) | (enumLiteral_1= 'STANDARD' ) | (enumLiteral_2= 'POLICY' ) ) ;
    public final Enumerator rulePrincipleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalScml.g:3189:2: ( ( (enumLiteral_0= 'LAW' ) | (enumLiteral_1= 'STANDARD' ) | (enumLiteral_2= 'POLICY' ) ) )
            // InternalScml.g:3190:2: ( (enumLiteral_0= 'LAW' ) | (enumLiteral_1= 'STANDARD' ) | (enumLiteral_2= 'POLICY' ) )
            {
            // InternalScml.g:3190:2: ( (enumLiteral_0= 'LAW' ) | (enumLiteral_1= 'STANDARD' ) | (enumLiteral_2= 'POLICY' ) )
            int alt54=3;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt54=1;
                }
                break;
            case 93:
                {
                alt54=2;
                }
                break;
            case 94:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalScml.g:3191:3: (enumLiteral_0= 'LAW' )
                    {
                    // InternalScml.g:3191:3: (enumLiteral_0= 'LAW' )
                    // InternalScml.g:3192:4: enumLiteral_0= 'LAW'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); 

                    				current = grammarAccess.getPrincipleTypeAccess().getLAWEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getPrincipleTypeAccess().getLAWEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalScml.g:3199:3: (enumLiteral_1= 'STANDARD' )
                    {
                    // InternalScml.g:3199:3: (enumLiteral_1= 'STANDARD' )
                    // InternalScml.g:3200:4: enumLiteral_1= 'STANDARD'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); 

                    				current = grammarAccess.getPrincipleTypeAccess().getSTANDARDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getPrincipleTypeAccess().getSTANDARDEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalScml.g:3207:3: (enumLiteral_2= 'POLICY' )
                    {
                    // InternalScml.g:3207:3: (enumLiteral_2= 'POLICY' )
                    // InternalScml.g:3208:4: enumLiteral_2= 'POLICY'
                    {
                    enumLiteral_2=(Token)match(input,94,FOLLOW_2); 

                    				current = grammarAccess.getPrincipleTypeAccess().getPOLICYEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getPrincipleTypeAccess().getPOLICYEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrincipleType"


    // $ANTLR start "ruleOperation"
    // InternalScml.g:3218:1: ruleOperation returns [Enumerator current=null] : ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'DIFF' ) | (enumLiteral_2= 'AVG' ) | (enumLiteral_3= 'MIN' ) | (enumLiteral_4= 'MAX' ) ) ;
    public final Enumerator ruleOperation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalScml.g:3224:2: ( ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'DIFF' ) | (enumLiteral_2= 'AVG' ) | (enumLiteral_3= 'MIN' ) | (enumLiteral_4= 'MAX' ) ) )
            // InternalScml.g:3225:2: ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'DIFF' ) | (enumLiteral_2= 'AVG' ) | (enumLiteral_3= 'MIN' ) | (enumLiteral_4= 'MAX' ) )
            {
            // InternalScml.g:3225:2: ( (enumLiteral_0= 'SUM' ) | (enumLiteral_1= 'DIFF' ) | (enumLiteral_2= 'AVG' ) | (enumLiteral_3= 'MIN' ) | (enumLiteral_4= 'MAX' ) )
            int alt55=5;
            switch ( input.LA(1) ) {
            case 95:
                {
                alt55=1;
                }
                break;
            case 96:
                {
                alt55=2;
                }
                break;
            case 97:
                {
                alt55=3;
                }
                break;
            case 98:
                {
                alt55=4;
                }
                break;
            case 99:
                {
                alt55=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalScml.g:3226:3: (enumLiteral_0= 'SUM' )
                    {
                    // InternalScml.g:3226:3: (enumLiteral_0= 'SUM' )
                    // InternalScml.g:3227:4: enumLiteral_0= 'SUM'
                    {
                    enumLiteral_0=(Token)match(input,95,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getSUMEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOperationAccess().getSUMEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalScml.g:3234:3: (enumLiteral_1= 'DIFF' )
                    {
                    // InternalScml.g:3234:3: (enumLiteral_1= 'DIFF' )
                    // InternalScml.g:3235:4: enumLiteral_1= 'DIFF'
                    {
                    enumLiteral_1=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getDIFFEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOperationAccess().getDIFFEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalScml.g:3242:3: (enumLiteral_2= 'AVG' )
                    {
                    // InternalScml.g:3242:3: (enumLiteral_2= 'AVG' )
                    // InternalScml.g:3243:4: enumLiteral_2= 'AVG'
                    {
                    enumLiteral_2=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getAVGEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOperationAccess().getAVGEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalScml.g:3250:3: (enumLiteral_3= 'MIN' )
                    {
                    // InternalScml.g:3250:3: (enumLiteral_3= 'MIN' )
                    // InternalScml.g:3251:4: enumLiteral_3= 'MIN'
                    {
                    enumLiteral_3=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getMINEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getOperationAccess().getMINEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalScml.g:3258:3: (enumLiteral_4= 'MAX' )
                    {
                    // InternalScml.g:3258:3: (enumLiteral_4= 'MAX' )
                    // InternalScml.g:3259:4: enumLiteral_4= 'MAX'
                    {
                    enumLiteral_4=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getOperationAccess().getMAXEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getOperationAccess().getMAXEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation"


    // $ANTLR start "ruleStatus"
    // InternalScml.g:3269:1: ruleStatus returns [Enumerator current=null] : ( (enumLiteral_0= 'GOOD' ) | (enumLiteral_1= 'WARN' ) | (enumLiteral_2= 'CRITICAL' ) ) ;
    public final Enumerator ruleStatus() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalScml.g:3275:2: ( ( (enumLiteral_0= 'GOOD' ) | (enumLiteral_1= 'WARN' ) | (enumLiteral_2= 'CRITICAL' ) ) )
            // InternalScml.g:3276:2: ( (enumLiteral_0= 'GOOD' ) | (enumLiteral_1= 'WARN' ) | (enumLiteral_2= 'CRITICAL' ) )
            {
            // InternalScml.g:3276:2: ( (enumLiteral_0= 'GOOD' ) | (enumLiteral_1= 'WARN' ) | (enumLiteral_2= 'CRITICAL' ) )
            int alt56=3;
            switch ( input.LA(1) ) {
            case 100:
                {
                alt56=1;
                }
                break;
            case 101:
                {
                alt56=2;
                }
                break;
            case 102:
                {
                alt56=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalScml.g:3277:3: (enumLiteral_0= 'GOOD' )
                    {
                    // InternalScml.g:3277:3: (enumLiteral_0= 'GOOD' )
                    // InternalScml.g:3278:4: enumLiteral_0= 'GOOD'
                    {
                    enumLiteral_0=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getStatusAccess().getGOODEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStatusAccess().getGOODEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalScml.g:3285:3: (enumLiteral_1= 'WARN' )
                    {
                    // InternalScml.g:3285:3: (enumLiteral_1= 'WARN' )
                    // InternalScml.g:3286:4: enumLiteral_1= 'WARN'
                    {
                    enumLiteral_1=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getStatusAccess().getWARNEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStatusAccess().getWARNEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalScml.g:3293:3: (enumLiteral_2= 'CRITICAL' )
                    {
                    // InternalScml.g:3293:3: (enumLiteral_2= 'CRITICAL' )
                    // InternalScml.g:3294:4: enumLiteral_2= 'CRITICAL'
                    {
                    enumLiteral_2=(Token)match(input,102,FOLLOW_2); 

                    				current = grammarAccess.getStatusAccess().getCRITICALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getStatusAccess().getCRITICALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatus"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000062000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000002040030L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000408000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000003040032L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0xEFDFA00000040000L,0x0000000000000003L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000002040032L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000030L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000081000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000000L,0x0000007000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000060000032L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000040000032L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000004000040L,0x0000000000000004L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000000L,0x00000000000F0000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000004000040000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x000000000FF00000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000180000040032L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x000FE00000040002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x000FA00000040002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000180000040030L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000000L,0x000000000000C000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x07F0000000040002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x07D0000000040002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0xF800000000040002L,0x0000000000000003L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0xE800000000040002L,0x0000000000000003L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000040L,0x0000000000000004L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000018L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000F80000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000200L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000070000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});

}
