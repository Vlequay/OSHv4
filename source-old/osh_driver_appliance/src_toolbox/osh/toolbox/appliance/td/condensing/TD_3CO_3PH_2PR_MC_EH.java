package osh.toolbox.appliance.td.condensing;

import osh.toolbox.appliance.ToolApplianceConfiguration;
import osh.toolbox.appliance.ToolApplianceConfigurationExtra;
import osh.toolbox.appliance.ToolApplianceConfigurationProfile;
import osh.toolbox.appliance.ToolApplianceConfigurationProgram;

/**
 * Dryer Low Energy 3 Configurations 3 Phase Multi Commodity
 * 
 * @author Ingo Mauser
 *
 */
public class TD_3CO_3PH_2PR_MC_EH {

	public static ToolApplianceConfiguration[] configurations = {
			new ToolApplianceConfiguration(
					0,
					new ToolApplianceConfigurationProgram(0, "Drying 0",
							"Drying 0", "wasssssccchn"),
					new ToolApplianceConfigurationExtra[] {},
					new ToolApplianceConfigurationProfile[] {
							new ToolApplianceConfigurationProfile(
									0,
									"pure electric uninterruptible",
									new String[] { "Drying 0", "Drying 1",
											"Drying 2", },
									new String[] {
											"data/profiles/renamed/td/TD_CO_pause.csv",
											"data/profiles/renamed/td/TD_CO_0.csv",
											"data/profiles/renamed/td/TD_CO_pause.csv", },
									0, 1, -1, -1),
							new ToolApplianceConfigurationProfile(
									1,
									"hybrid uninterruptible",
									new String[] { "Drying 0", "Drying 1",
											"Drying 2",  },
									new String[] {
											"data/profiles/renamed/td/TD_CO_pause.csv",
											"data/profiles/renamed/td/TD_CO_0_MC.csv",
											"data/profiles/renamed/td/TD_CO_pause.csv", },
									0, 1, 2, -1), }),
			new ToolApplianceConfiguration(
					1,
					new ToolApplianceConfigurationProgram(0, "Drying 1",
							"Drying 1", "wasssssccchn"),
					new ToolApplianceConfigurationExtra[] {},
					new ToolApplianceConfigurationProfile[] {
							new ToolApplianceConfigurationProfile(
									0,
									"pure electric uninterruptible",
									new String[] { "Drying 0", "Drying 1",
											"Drying 2",  },
									new String[] {
											"data/profiles/renamed/td/TD_CO_pause.csv",
											"data/profiles/renamed/td/TD_CO_1.csv",
											"data/profiles/renamed/td/TD_CO_pause.csv", },
									0, 1, -1, -1),
							new ToolApplianceConfigurationProfile(
									1,
									"hybrid uninterruptible",
									new String[] { "Drying 0", "Drying 1",
											"Drying 2", },
									new String[] {
											"data/profiles/renamed/td/TD_CO_pause.csv",
											"data/profiles/renamed/td/TD_CO_1_MC.csv",
											"data/profiles/renamed/td/TD_CO_pause.csv", },
									0, 1, 2, -1), }),
			new ToolApplianceConfiguration(
					2,
					new ToolApplianceConfigurationProgram(0, "Drying 2",
							"Drying 2", "wasssssccchn"),
					new ToolApplianceConfigurationExtra[] {},
					new ToolApplianceConfigurationProfile[] {
							new ToolApplianceConfigurationProfile(
									0,
									"pure electric uninterruptible",
									new String[] { "Drying 0", "Drying 1",
											"Drying 2", },
									new String[] {
											"data/profiles/renamed/td/TD_CO_pause.csv",
											"data/profiles/renamed/td/TD_CO_2.csv",
											"data/profiles/renamed/td/TD_CO_pause.csv", },
									0, 1, -1, -1),
							new ToolApplianceConfigurationProfile(
									1,
									"hybrid uninterruptible",
									new String[] { "Drying 0", "Drying 1",
											"Drying 2",},
									new String[] {
											"data/profiles/renamed/td/TD_CO_pause.csv",
											"data/profiles/renamed/td/TD_CO_2_MC.csv",
											"data/profiles/renamed/td/TD_CO_pause.csv", },
									0, 1, 2, -1), }) };

}
