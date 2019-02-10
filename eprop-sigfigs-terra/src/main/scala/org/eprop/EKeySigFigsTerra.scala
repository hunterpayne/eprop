
package org.eprop

import shapeless.HMap

import org.sigfigs.terra._
import org.sigfigs.terra.electro.{ 
  ElectricCurrent, Capacitance, Conductivity, ElectricCharge, 
  ElectricPotential, ElectricalConductance, ElectricalResistance, Inductance, 
  MagneticFlux, MagneticFluxDensity, Resistivity }
import org.sigfigs.terra.energy.{ 
  Energy, PowerDensity, EnergyDensity, Power, PowerRamp, SpecificEnergy, 
  MolarEnergy }
import org.sigfigs.terra.information.{ DataRate, Information }
import org.sigfigs.terra.market.Money
import org.sigfigs.terra.mass.{ AreaDensity, Density, Mass, ChemicalAmount }
import org.sigfigs.terra.motion.{
  Acceleration, AngularAcceleration, AngularVelocity, Force, Jerk, MassFlow, 
  Momentum, Pressure, PressureChange, Velocity, VolumeFlow, Yank }
import org.sigfigs.terra.photo.{ 
  Illuminance, Luminance, LuminousEnergy, LuminousExposure, LuminousFlux,
  LuminousIntensity }
import org.sigfigs.terra.radio.{ 
  Irradiance, Radiance, SpectralIntensity, SpectralIrradiance, SpectralPower,
  Activity, ParticleFlux, Dose, AreaTime }
import org.sigfigs.terra.space.{ Angle, Area, Length, Volume, SolidAngle }
import org.sigfigs.terra.thermal.{ Temperature, ThermalCapacity } 
import org.sigfigs.terra.time.{ Time, Frequency, TimeSquared }

/**
  * a scope containing all the implicit type conversions necessary to
  * make the as method of the property object which generates the EProperty
  * which can be casted to a tuple suitable to be added to a HMap
  */
object EKeySigFigsTerra {

  import EKey._

  // declarations and type conversions necessary to store the EKeys into
  // a shapeless.HMap
  implicit val dimensionlessElemKeyToValue = 
    new PropMap[EKeyType[Dimensionless], Dimensionless]

  implicit val electricCurrentElemKeyToValue = 
    new PropMap[EKeyType[ElectricCurrent], ElectricCurrent]
  implicit val capacitanceElemKeyToValue = 
    new PropMap[EKeyType[Capacitance], Capacitance]
  implicit val conductivityElemKeyToValue = 
    new PropMap[EKeyType[Conductivity], Conductivity]
  implicit val electricChargeElemKeyToValue = 
    new PropMap[EKeyType[ElectricCharge], ElectricCharge]
  implicit val electricPotentialElemKeyToValue = 
    new PropMap[EKeyType[ElectricPotential], ElectricPotential]
  implicit val electricalConductanceElemKeyToValue = 
    new PropMap[EKeyType[ElectricalConductance], ElectricalConductance]
  implicit val electricalResistanceElemKeyToValue = 
    new PropMap[EKeyType[ElectricalResistance], ElectricalResistance]
  implicit val inductanceElemKeyToValue = 
    new PropMap[EKeyType[Inductance], Inductance]
  implicit val magneticFluxElemKeyToValue = 
    new PropMap[EKeyType[MagneticFlux], MagneticFlux]
  implicit val magneticFluxDensityElemKeyToValue = 
    new PropMap[EKeyType[MagneticFluxDensity], MagneticFluxDensity]
  implicit val resistivityElemKeyToValue = 
    new PropMap[EKeyType[Resistivity], Resistivity]

  implicit val energyElemKeyToValue = new PropMap[EKeyType[Energy], Energy]
  implicit val powerDensityElemKeyToValue = 
    new PropMap[EKeyType[PowerDensity], PowerDensity]
  implicit val energyDensityElemKeyToValue = 
    new PropMap[EKeyType[EnergyDensity], EnergyDensity]
  implicit val powerElemKeyToValue = new PropMap[EKeyType[Power], Power]
  implicit val powerRampElemKeyToValue = 
    new PropMap[EKeyType[PowerRamp], PowerRamp]
  implicit val specificEnergyElemKeyToValue = 
    new PropMap[EKeyType[SpecificEnergy], SpecificEnergy]
  implicit val molarEnergyElemKeyToValue = 
    new PropMap[EKeyType[MolarEnergy], MolarEnergy]

  implicit val dataRateElemKeyToValue = 
    new PropMap[EKeyType[DataRate], DataRate]
  implicit val informationElemKeyToValue = 
    new PropMap[EKeyType[Information], Information]

  implicit val moneyElemKeyToValue = new PropMap[EKeyType[Money], Money]

  implicit val areaDensityElemKeyToValue =
    new PropMap[EKeyType[AreaDensity], AreaDensity]
  implicit val densityElemKeyToValue = 
    new PropMap[EKeyType[Density], Density]
  implicit val massElemKeyToValue = new PropMap[EKeyType[Mass], Mass]
  implicit val chemicalAmountElemKeyToValue = 
    new PropMap[EKeyType[ChemicalAmount], ChemicalAmount]

  implicit val accelerationElemKeyToValue = 
    new PropMap[EKeyType[Acceleration], Acceleration]
  implicit val angularAccelerationElemKeyToValue = 
    new PropMap[EKeyType[AngularAcceleration], AngularAcceleration]
  implicit val angularVelocityElemKeyToValue = 
    new PropMap[EKeyType[AngularVelocity], AngularVelocity]
  implicit val forceElemKeyToValue = new PropMap[EKeyType[Force], Force]
  implicit val jerkElemKeyToValue = new PropMap[EKeyType[Jerk], Jerk]
  implicit val massFlowElemKeyToValue = 
    new PropMap[EKeyType[MassFlow], MassFlow]
  implicit val momentumElemKeyToValue = 
    new PropMap[EKeyType[Momentum], Momentum]
  implicit val pressureChangeElemKeyToValue = 
    new PropMap[EKeyType[PressureChange], PressureChange]
  implicit val pressureElemKeyToValue = 
    new PropMap[EKeyType[Pressure], Pressure]
  implicit val velocityElemKeyToValue = 
    new PropMap[EKeyType[Velocity], Velocity]
  implicit val volumeFlowElemKeyToValue = 
    new PropMap[EKeyType[VolumeFlow], VolumeFlow]
  implicit val yankElemKeyToValue = new PropMap[EKeyType[Yank], Yank]

  implicit val illuminanceElemKeyToValue = 
    new PropMap[EKeyType[Illuminance], Illuminance]
  implicit val luminanceElemKeyToValue = 
    new PropMap[EKeyType[Luminance], Luminance]
  implicit val luminousEnergyElemKeyToValue = 
    new PropMap[EKeyType[LuminousEnergy], LuminousEnergy]
  implicit val luminousExposureElemKeyToValue = 
    new PropMap[EKeyType[LuminousExposure], LuminousExposure]
  implicit val luminousFluxElemKeyToValue = 
    new PropMap[EKeyType[LuminousFlux], LuminousFlux]
  implicit val luminousIntensityElemKeyToValue = 
    new PropMap[EKeyType[LuminousIntensity], LuminousIntensity]

  implicit val irradianceElemKeyToValue = 
    new PropMap[EKeyType[Irradiance], Irradiance]
  implicit val radianceElemKeyToValue = 
    new PropMap[EKeyType[Radiance], Radiance]
  implicit val spectralIntensityElemKeyToValue = 
    new PropMap[EKeyType[SpectralIntensity], SpectralIntensity]
  implicit val spectralIrradianceElemKeyToValue = 
    new PropMap[EKeyType[SpectralIrradiance], SpectralIrradiance]
  implicit val spectralPowerElemKeyToValue = 
    new PropMap[EKeyType[SpectralPower], SpectralPower]
  implicit val activityElemKeyToValue = 
    new PropMap[EKeyType[Activity], Activity]
  implicit val particleFluxElemKeyToValue = 
    new PropMap[EKeyType[ParticleFlux], ParticleFlux]
  implicit val doseElemKeyToValue = new PropMap[EKeyType[Dose], Dose]
  implicit val areaTimeElemKeyToValue = 
    new PropMap[EKeyType[AreaTime], AreaTime]

  implicit val angleElemKeyToValue = new PropMap[EKeyType[Angle], Angle]
  implicit val lengthElemKeyToValue = new PropMap[EKeyType[Length], Length]
  implicit val areaElemKeyToValue = new PropMap[EKeyType[Area], Area]
  implicit val volElemKeyToValue = new PropMap[EKeyType[Volume], Volume]
  implicit val solidAngleElemKeyToValue = 
    new PropMap[EKeyType[SolidAngle], SolidAngle]

  implicit val tempElemKeyToValue = 
    new PropMap[EKeyType[Temperature], Temperature]
  implicit val thermalCapacityElemKeyToValue = 
    new PropMap[EKeyType[ThermalCapacity], ThermalCapacity]

  implicit val timeElemKeyToValue = new PropMap[EKeyType[Time], Time]
  implicit val frequencyElemKeyToValue = 
    new PropMap[EKeyType[Frequency], Frequency]
  implicit val timeSquaredElemKeyToValue = 
    new PropMap[EKeyType[TimeSquared], TimeSquared]


  // implicit type conversions
  implicit val dimensionlessConv: EKey[Dimensionless] =
    new EKey[Dimensionless] {
      def as(symbol: Symbol, value: Dimensionless): EProperty[Dimensionless] =
        EProperty[Dimensionless](symbol, value)
      def as(symbol: EKeyType[Dimensionless], value: Dimensionless): 
          EProperty[Dimensionless] = 
        EProperty[Dimensionless](symbol.sym, value)
    }


  implicit val electricCurrentConv: EKey[ElectricCurrent] =
    new EKey[ElectricCurrent] {
      def as(
        symbol: Symbol, value: ElectricCurrent): EProperty[ElectricCurrent] =
        EProperty[ElectricCurrent](symbol, value)
      def as(symbol: EKeyType[ElectricCurrent], value: ElectricCurrent): 
          EProperty[ElectricCurrent] = 
        EProperty[ElectricCurrent](symbol.sym, value)
    }

  implicit val capacitanceConv: EKey[Capacitance] =
    new EKey[Capacitance] {
      def as(symbol: Symbol, value: Capacitance): EProperty[Capacitance] =
        EProperty[Capacitance](symbol, value)
      def as(symbol: EKeyType[Capacitance], value: Capacitance): 
          EProperty[Capacitance] = 
        EProperty[Capacitance](symbol.sym, value)
    }

  implicit val conductivityConv: EKey[Conductivity] =
    new EKey[Conductivity] {
      def as(symbol: Symbol, value: Conductivity): EProperty[Conductivity] =
        EProperty[Conductivity](symbol, value)
      def as(symbol: EKeyType[Conductivity], value: Conductivity): 
          EProperty[Conductivity] = 
        EProperty[Conductivity](symbol.sym, value)
    }

  implicit val electricChargeConv: EKey[ElectricCharge] =
    new EKey[ElectricCharge] {
      def as(symbol: Symbol, value: ElectricCharge): EProperty[ElectricCharge] =
        EProperty[ElectricCharge](symbol, value)
      def as(symbol: EKeyType[ElectricCharge], value: ElectricCharge): 
          EProperty[ElectricCharge] = 
        EProperty[ElectricCharge](symbol.sym, value)
    }

  implicit val electricPotentialConv: EKey[ElectricPotential] =
    new EKey[ElectricPotential] {
      def as(symbol: Symbol, value: ElectricPotential): 
          EProperty[ElectricPotential] =
        EProperty[ElectricPotential](symbol, value)
      def as(symbol: EKeyType[ElectricPotential], value: ElectricPotential): 
          EProperty[ElectricPotential] = 
        EProperty[ElectricPotential](symbol.sym, value)
    }

  implicit val electricalConductanceConv: EKey[ElectricalConductance] =
    new EKey[ElectricalConductance] {
      def as(symbol: Symbol, value: ElectricalConductance): 
          EProperty[ElectricalConductance] =
        EProperty[ElectricalConductance](symbol, value)
      def as(
        symbol: EKeyType[ElectricalConductance], value: ElectricalConductance):
          EProperty[ElectricalConductance] = 
        EProperty[ElectricalConductance](symbol.sym, value)
    }

  implicit val electricalResistanceConv: EKey[ElectricalResistance] =
    new EKey[ElectricalResistance] {
      def as(symbol: Symbol, value: ElectricalResistance): 
          EProperty[ElectricalResistance] =
        EProperty[ElectricalResistance](symbol, value)
      def as(
        symbol: EKeyType[ElectricalResistance], value: ElectricalResistance):
          EProperty[ElectricalResistance] = 
        EProperty[ElectricalResistance](symbol.sym, value)
    }

  implicit val inductanceConv: EKey[Inductance] =
    new EKey[Inductance] {
      def as(symbol: Symbol, value: Inductance): EProperty[Inductance] =
        EProperty[Inductance](symbol, value)
      def as(symbol: EKeyType[Inductance], value: Inductance): 
          EProperty[Inductance] = 
        EProperty[Inductance](symbol.sym, value)
    }

  implicit val magneticFluxConv: EKey[MagneticFlux] =
    new EKey[MagneticFlux] {
      def as(symbol: Symbol, value: MagneticFlux): EProperty[MagneticFlux] =
        EProperty[MagneticFlux](symbol, value)
      def as(symbol: EKeyType[MagneticFlux], value: MagneticFlux): 
          EProperty[MagneticFlux] = 
        EProperty[MagneticFlux](symbol.sym, value)
    }

  implicit val magneticFluxDensityConv: EKey[MagneticFluxDensity] =
    new EKey[MagneticFluxDensity] {
      def as(symbol: Symbol, value: MagneticFluxDensity): 
          EProperty[MagneticFluxDensity] =
        EProperty[MagneticFluxDensity](symbol, value)
      def as(symbol: EKeyType[MagneticFluxDensity], value: MagneticFluxDensity):
          EProperty[MagneticFluxDensity] = 
        EProperty[MagneticFluxDensity](symbol.sym, value)
    }

  implicit val resistivityConv: EKey[Resistivity] =
    new EKey[Resistivity] {
      def as(symbol: Symbol, value: Resistivity): EProperty[Resistivity] =
        EProperty[Resistivity](symbol, value)
      def as(symbol: EKeyType[Resistivity], value: Resistivity): 
          EProperty[Resistivity] = 
        EProperty[Resistivity](symbol.sym, value)
    }


  implicit val energyConv: EKey[Energy] =
    new EKey[Energy] {
      def as(symbol: Symbol, value: Energy): EProperty[Energy] = 
        EProperty[Energy](symbol, value)
      def as(symbol: EKeyType[Energy], value: Energy): 
          EProperty[Energy] = 
        EProperty[Energy](symbol.sym, value)
    }

  implicit val powerDensityConv: EKey[PowerDensity] =
    new EKey[PowerDensity] {
      def as(symbol: Symbol, value: PowerDensity): EProperty[PowerDensity] = 
        EProperty[PowerDensity](symbol, value)
      def as(symbol: EKeyType[PowerDensity], value: PowerDensity): 
          EProperty[PowerDensity] = 
        EProperty[PowerDensity](symbol.sym, value)
    }

  implicit val energyDensityConv: EKey[EnergyDensity] =
    new EKey[EnergyDensity] {
      def as(symbol: Symbol, value: EnergyDensity): EProperty[EnergyDensity] = 
        EProperty[EnergyDensity](symbol, value)
      def as(symbol: EKeyType[EnergyDensity], value: EnergyDensity): 
          EProperty[EnergyDensity] = 
        EProperty[EnergyDensity](symbol.sym, value)
    }

  implicit val powerConv: EKey[Power] =
    new EKey[Power] {
      def as(symbol: Symbol, value: Power): EProperty[Power] = 
        EProperty[Power](symbol, value)
      def as(symbol: EKeyType[Power], value: Power): 
          EProperty[Power] = 
        EProperty[Power](symbol.sym, value)
    }

  implicit val powerRampConv: EKey[PowerRamp] =
    new EKey[PowerRamp] {
      def as(symbol: Symbol, value: PowerRamp): EProperty[PowerRamp] = 
        EProperty[PowerRamp](symbol, value)
      def as(symbol: EKeyType[PowerRamp], value: PowerRamp): 
          EProperty[PowerRamp] =
        EProperty[PowerRamp](symbol.sym, value)
    }

  implicit val specificEnergyConv: EKey[SpecificEnergy] =
    new EKey[SpecificEnergy] {
      def as(symbol: Symbol, value: SpecificEnergy): EProperty[SpecificEnergy] =
        EProperty[SpecificEnergy](symbol, value)
      def as(symbol: EKeyType[SpecificEnergy], value: SpecificEnergy): 
          EProperty[SpecificEnergy] = 
        EProperty[SpecificEnergy](symbol.sym, value)
    }

  implicit val molarEnergyConv: EKey[MolarEnergy] =
    new EKey[MolarEnergy] {
      def as(symbol: Symbol, value: MolarEnergy): EProperty[MolarEnergy] = 
        EProperty[MolarEnergy](symbol, value)
      def as(symbol: EKeyType[MolarEnergy], value: MolarEnergy): 
          EProperty[MolarEnergy] = 
        EProperty[MolarEnergy](symbol.sym, value)
    }


  implicit val dataRateConv: EKey[DataRate] =
    new EKey[DataRate] {
      def as(symbol: Symbol, value: DataRate): EProperty[DataRate] = 
        EProperty[DataRate](symbol, value)
      def as(symbol: EKeyType[DataRate], value: DataRate): 
          EProperty[DataRate] = 
        EProperty[DataRate](symbol.sym, value)
    }

  implicit val informationConv: EKey[Information] =
    new EKey[Information] {
      def as(symbol: Symbol, value: Information): EProperty[Information] = 
        EProperty[Information](symbol, value)
      def as(symbol: EKeyType[Information], value: Information): 
          EProperty[Information] = 
        EProperty[Information](symbol.sym, value)
    }


  implicit val moneyConv: EKey[Money] =
    new EKey[Money] {
      def as(symbol: Symbol, value: Money): EProperty[Money] = 
        EProperty[Money](symbol, value)
      def as(symbol: EKeyType[Money], value: Money): 
          EProperty[Money] = 
        EProperty[Money](symbol.sym, value)
    }

  implicit val areaDensityConv: EKey[AreaDensity] =
    new EKey[AreaDensity] {
      def as(symbol: Symbol, value: AreaDensity): EProperty[AreaDensity] = 
        EProperty[AreaDensity](symbol, value)
      def as(symbol: EKeyType[AreaDensity], value: AreaDensity): 
          EProperty[AreaDensity] = 
        EProperty[AreaDensity](symbol.sym, value)
    }

  implicit val densityConv: EKey[Density] =
    new EKey[Density] {
      def as(symbol: Symbol, value: Density): EProperty[Density] = 
        EProperty[Density](symbol, value)
      def as(symbol: EKeyType[Density], value: Density): 
          EProperty[Density] =
        EProperty[Density](symbol.sym, value)
    }

  implicit val massConv: EKey[Mass] =
    new EKey[Mass] {
      def as(symbol: Symbol, value: Mass): EProperty[Mass] = 
        EProperty[Mass](symbol, value)
      def as(symbol: EKeyType[Mass], value: Mass): 
          EProperty[Mass] = 
        EProperty[Mass](symbol.sym, value)
    }

  implicit val chemicalAmountConv: EKey[ChemicalAmount] =
    new EKey[ChemicalAmount] {
      def as(symbol: Symbol, value: ChemicalAmount): EProperty[ChemicalAmount] =
        EProperty[ChemicalAmount](symbol, value)
      def as(symbol: EKeyType[ChemicalAmount], value: ChemicalAmount): 
          EProperty[ChemicalAmount] = 
        EProperty[ChemicalAmount](symbol.sym, value)
    }


  implicit val accelerationConv: EKey[Acceleration] =
    new EKey[Acceleration] {
      def as(symbol: Symbol, value: Acceleration): EProperty[Acceleration] =
        EProperty[Acceleration](symbol, value)
      def as(symbol: EKeyType[Acceleration], value: Acceleration): 
          EProperty[Acceleration] = 
        EProperty[Acceleration](symbol.sym, value)
    }

  implicit val angularAccelerationConv: EKey[AngularAcceleration] =
    new EKey[AngularAcceleration] {
      def as(symbol: Symbol, value: AngularAcceleration): 
          EProperty[AngularAcceleration] =
        EProperty[AngularAcceleration](symbol, value)
      def as(symbol: EKeyType[AngularAcceleration], value: AngularAcceleration):
          EProperty[AngularAcceleration] = 
        EProperty[AngularAcceleration](symbol.sym, value)
    }

  implicit val angularVelocityConv: EKey[AngularVelocity] =
    new EKey[AngularVelocity] {
      def as(symbol: Symbol, value: AngularVelocity): 
          EProperty[AngularVelocity] =
        EProperty[AngularVelocity](symbol, value)
      def as(symbol: EKeyType[AngularVelocity], value: AngularVelocity): 
          EProperty[AngularVelocity] = 
        EProperty[AngularVelocity](symbol.sym, value)
    }

  implicit val forceConv: EKey[Force] =
    new EKey[Force] {
      def as(symbol: Symbol, value: Force): EProperty[Force] = 
        EProperty[Force](symbol, value)
      def as(symbol: EKeyType[Force], value: Force): 
          EProperty[Force] = 
        EProperty[Force](symbol.sym, value)
    }

  implicit val jerkConv: EKey[Jerk] =
    new EKey[Jerk] {
      def as(symbol: Symbol, value: Jerk): EProperty[Jerk] = 
        EProperty[Jerk](symbol, value)
      def as(symbol: EKeyType[Jerk], value: Jerk): 
          EProperty[Jerk] = 
        EProperty[Jerk](symbol.sym, value)
    }

  implicit val massFlowConv: EKey[MassFlow] =
    new EKey[MassFlow] {
      def as(symbol: Symbol, value: MassFlow): EProperty[MassFlow] = 
        EProperty[MassFlow](symbol, value)
      def as(symbol: EKeyType[MassFlow], value: MassFlow): 
          EProperty[MassFlow] = 
        EProperty[MassFlow](symbol.sym, value)
    }

  implicit val momentumConv: EKey[Momentum] =
    new EKey[Momentum] {
      def as(symbol: Symbol, value: Momentum): EProperty[Momentum] = 
        EProperty[Momentum](symbol, value)
      def as(symbol: EKeyType[Momentum], value: Momentum): 
          EProperty[Momentum] = 
        EProperty[Momentum](symbol.sym, value)
    }

  implicit val pressureConv: EKey[Pressure] =
    new EKey[Pressure] {
      def as(symbol: Symbol, value: Pressure): EProperty[Pressure] = 
        EProperty[Pressure](symbol, value)
      def as(symbol: EKeyType[Pressure], value: Pressure): 
          EProperty[Pressure] = 
        EProperty[Pressure](symbol.sym, value)
    }

  implicit val pressureChangeConv: EKey[PressureChange] =
    new EKey[PressureChange] {
      def as(symbol: Symbol, value: PressureChange): EProperty[PressureChange] =
        EProperty[PressureChange](symbol, value)
      def as(symbol: EKeyType[PressureChange], value: PressureChange): 
          EProperty[PressureChange] = 
        EProperty[PressureChange](symbol.sym, value)
    }

  implicit val velocityConv: EKey[Velocity] =
    new EKey[Velocity] {
      def as(symbol: Symbol, value: Velocity): EProperty[Velocity] = 
        EProperty[Velocity](symbol, value)
      def as(symbol: EKeyType[Velocity], value: Velocity): 
          EProperty[Velocity] = 
        EProperty[Velocity](symbol.sym, value)
    }

  implicit val volumeFlowConv: EKey[VolumeFlow] =
    new EKey[VolumeFlow] {
      def as(symbol: Symbol, value: VolumeFlow): EProperty[VolumeFlow] = 
        EProperty[VolumeFlow](symbol, value)
      def as(symbol: EKeyType[VolumeFlow], value: VolumeFlow): 
          EProperty[VolumeFlow] = 
        EProperty[VolumeFlow](symbol.sym, value)
    }

  implicit val yankConv: EKey[Yank] =
    new EKey[Yank] {
      def as(symbol: Symbol, value: Yank): EProperty[Yank] = 
        EProperty[Yank](symbol, value)
      def as(symbol: EKeyType[Yank], value: Yank): 
          EProperty[Yank] = 
        EProperty[Yank](symbol.sym, value)
    }


  implicit val illuminanceConv: EKey[Illuminance] =
    new EKey[Illuminance] {
      def as(symbol: Symbol, value: Illuminance): EProperty[Illuminance] =
        EProperty[Illuminance](symbol, value)
      def as(symbol: EKeyType[Illuminance], value: Illuminance): 
          EProperty[Illuminance] = 
        EProperty[Illuminance](symbol.sym, value)
    }

  implicit val luminanceConv: EKey[Luminance] =
    new EKey[Luminance] {
      def as(symbol: Symbol, value: Luminance): EProperty[Luminance] =
        EProperty[Luminance](symbol, value)
      def as(symbol: EKeyType[Luminance], value: Luminance): 
          EProperty[Luminance] = 
        EProperty[Luminance](symbol.sym, value)
    }

  implicit val luminousEnergyConv: EKey[LuminousEnergy] =
    new EKey[LuminousEnergy] {
      def as(symbol: Symbol, value: LuminousEnergy): EProperty[LuminousEnergy] =
        EProperty[LuminousEnergy](symbol, value)
      def as(symbol: EKeyType[LuminousEnergy], value: LuminousEnergy): 
          EProperty[LuminousEnergy] = 
        EProperty[LuminousEnergy](symbol.sym, value)
    }

  implicit val luminousExposureConv: EKey[LuminousExposure] =
    new EKey[LuminousExposure] {
      def as(
        symbol: Symbol, value: LuminousExposure): EProperty[LuminousExposure] =
        EProperty[LuminousExposure](symbol, value)
      def as(symbol: EKeyType[LuminousExposure], value: LuminousExposure): 
          EProperty[LuminousExposure] = 
        EProperty[LuminousExposure](symbol.sym, value)
    }

  implicit val luminousFluxConv: EKey[LuminousFlux] =
    new EKey[LuminousFlux] {
      def as(symbol: Symbol, value: LuminousFlux): EProperty[LuminousFlux] =
        EProperty[LuminousFlux](symbol, value)
      def as(symbol: EKeyType[LuminousFlux], value: LuminousFlux): 
          EProperty[LuminousFlux] = 
        EProperty[LuminousFlux](symbol.sym, value)
    }

  implicit val luminousIntensityConv: EKey[LuminousIntensity] =
    new EKey[LuminousIntensity] {
      def as(symbol: Symbol, value: LuminousIntensity): 
          EProperty[LuminousIntensity] =
        EProperty[LuminousIntensity](symbol, value)
      def as(symbol: EKeyType[LuminousIntensity], value: LuminousIntensity): 
          EProperty[LuminousIntensity] = 
        EProperty[LuminousIntensity](symbol.sym, value)
    }


  implicit val irradianceConv: EKey[Irradiance] =
    new EKey[Irradiance] {
      def as(symbol: Symbol, value: Irradiance): EProperty[Irradiance] = 
        EProperty[Irradiance](symbol, value)
      def as(symbol: EKeyType[Irradiance], value: Irradiance): 
          EProperty[Irradiance] = 
        EProperty[Irradiance](symbol.sym, value)
    }

  implicit val radianceConv: EKey[Radiance] =
    new EKey[Radiance] {
      def as(symbol: Symbol, value: Radiance): EProperty[Radiance] = 
        EProperty[Radiance](symbol, value)
      def as(symbol: EKeyType[Radiance], value: Radiance): 
          EProperty[Radiance] = 
        EProperty[Radiance](symbol.sym, value)
    }

  implicit val spectralIntensityConv: EKey[SpectralIntensity] =
    new EKey[SpectralIntensity] {
      def as(symbol: Symbol, value: SpectralIntensity): 
          EProperty[SpectralIntensity] =
        EProperty[SpectralIntensity](symbol, value)
      def as(symbol: EKeyType[SpectralIntensity], value: SpectralIntensity): 
          EProperty[SpectralIntensity] = 
        EProperty[SpectralIntensity](symbol.sym, value)
    }

  implicit val spectralIrradianceConv: EKey[SpectralIrradiance] =
    new EKey[SpectralIrradiance] {
      def as(symbol: Symbol, value: SpectralIrradiance): 
          EProperty[SpectralIrradiance] =
        EProperty[SpectralIrradiance](symbol, value)
      def as(symbol: EKeyType[SpectralIrradiance], value: SpectralIrradiance): 
          EProperty[SpectralIrradiance] = 
        EProperty[SpectralIrradiance](symbol.sym, value)
    }

  implicit val spectralPowerConv: EKey[SpectralPower] =
    new EKey[SpectralPower] {
      def as(symbol: Symbol, value: SpectralPower): EProperty[SpectralPower] = 
        EProperty[SpectralPower](symbol, value)
      def as(symbol: EKeyType[SpectralPower], value: SpectralPower): 
          EProperty[SpectralPower] = 
        EProperty[SpectralPower](symbol.sym, value)
    }

  implicit val activityConv: EKey[Activity] =
    new EKey[Activity] {
      def as(symbol: Symbol, value: Activity): EProperty[Activity] =
        EProperty[Activity](symbol, value)
      def as(symbol: EKeyType[Activity], value: Activity): 
          EProperty[Activity] = 
        EProperty[Activity](symbol.sym, value)
    }

  implicit val particleFluxConv: EKey[ParticleFlux] =
    new EKey[ParticleFlux] {
      def as(symbol: Symbol, value: ParticleFlux): EProperty[ParticleFlux] =
        EProperty[ParticleFlux](symbol, value)
      def as(symbol: EKeyType[ParticleFlux], value: ParticleFlux): 
          EProperty[ParticleFlux] = 
        EProperty[ParticleFlux](symbol.sym, value)
    }

  implicit val doseConv: EKey[Dose] =
    new EKey[Dose] {
      def as(symbol: Symbol, value: Dose): EProperty[Dose] =
        EProperty[Dose](symbol, value)
      def as(symbol: EKeyType[Dose], value: Dose): 
          EProperty[Dose] = 
        EProperty[Dose](symbol.sym, value)
    }

  implicit val areaTimeConv: EKey[AreaTime] =
    new EKey[AreaTime] {
      def as(symbol: Symbol, value: AreaTime): EProperty[AreaTime] =
        EProperty[AreaTime](symbol, value)
      def as(symbol: EKeyType[AreaTime], value: AreaTime): 
          EProperty[AreaTime] = 
        EProperty[AreaTime](symbol.sym, value)
    }


  implicit val angleConv: EKey[Angle] =
    new EKey[Angle] {
      def as(symbol: Symbol, value: Angle): EProperty[Angle] =
        EProperty[Angle](symbol, value)
      def as(symbol: EKeyType[Angle], value: Angle): 
          EProperty[Angle] = 
        EProperty[Angle](symbol.sym, value)
    }

  implicit val lengthConv: EKey[Length] =
    new EKey[Length] {
      def as(symbol: Symbol, value: Length): EProperty[Length] = 
        EProperty[Length](symbol, value)
      def as(symbol: EKeyType[Length], value: Length): 
          EProperty[Length] = 
        EProperty[Length](symbol.sym, value)
    }

  implicit val areaConv: EKey[Area] =
    new EKey[Area] {
      def as(symbol: Symbol, value: Area): EProperty[Area] = 
        EProperty[Area](symbol, value)
      def as(symbol: EKeyType[Area], value: Area): 
          EProperty[Area] = 
        EProperty[Area](symbol.sym, value)
    }

  implicit val volumeConv: EKey[Volume] =
    new EKey[Volume] {
      def as(symbol: Symbol, value: Volume): EProperty[Volume] = 
        EProperty[Volume](symbol, value)
      def as(symbol: EKeyType[Volume], value: Volume): 
          EProperty[Volume] = 
        EProperty[Volume](symbol.sym, value)
    }

  implicit val solidAngleConv: EKey[SolidAngle] =
    new EKey[SolidAngle] {
      def as(symbol: Symbol, value: SolidAngle): EProperty[SolidAngle] =
        EProperty[SolidAngle](symbol, value)
      def as(symbol: EKeyType[SolidAngle], value: SolidAngle): 
          EProperty[SolidAngle] = 
        EProperty[SolidAngle](symbol.sym, value)
    }


  implicit val tempConv: EKey[Temperature] =
    new EKey[Temperature] {
      def as(symbol: Symbol, value: Temperature): EProperty[Temperature] =
        EProperty[Temperature](symbol, value)
      def as(symbol: EKeyType[Temperature], value: Temperature): 
          EProperty[Temperature] =
        EProperty[Temperature](symbol.sym, value)
    }

  implicit val thermalCapacityConv: EKey[ThermalCapacity] =
    new EKey[ThermalCapacity] {
      def as(symbol: Symbol, value: ThermalCapacity): 
          EProperty[ThermalCapacity] =
        EProperty[ThermalCapacity](symbol, value)
      def as(symbol: EKeyType[ThermalCapacity], value: ThermalCapacity): 
          EProperty[ThermalCapacity] = 
        EProperty[ThermalCapacity](symbol.sym, value)
    }


  implicit val timeConv: EKey[Time] =
    new EKey[Time] {
      def as(symbol: Symbol, value: Time): EProperty[Time] = 
        EProperty[Time](symbol, value)
      def as(symbol: EKeyType[Time], value: Time): 
          EProperty[Time] = 
        EProperty[Time](symbol.sym, value)
    }

  implicit val frequencyConv: EKey[Frequency] =
    new EKey[Frequency] {
      def as(symbol: Symbol, value: Frequency): EProperty[Frequency] =
        EProperty[Frequency](symbol, value)
      def as(symbol: EKeyType[Frequency], value: Frequency): 
          EProperty[Frequency] = 
        EProperty[Frequency](symbol.sym, value)
    }

  implicit val timeSquaredConv: EKey[TimeSquared] =
    new EKey[TimeSquared] {
      def as(symbol: Symbol, value: TimeSquared): EProperty[TimeSquared] =
        EProperty[TimeSquared](symbol, value)
      def as(symbol: EKeyType[TimeSquared], value: TimeSquared): 
          EProperty[TimeSquared] = 
        EProperty[TimeSquared](symbol.sym, value)
    }

  /**
    * trait to extend if you want to use extensible EKeys in a specific class
    */
  object SigFigsTerraExtensible extends HasConv {

    def conv(builder: HMapBuilder, t: Any): Boolean =
      t match {
        case EProperty(k, v) => v match {
          case m: Dimensionless =>
            builder.add[Dimensionless](
              new EKeyType[Dimensionless](k), 
              t.asInstanceOf[EProperty[Dimensionless]])
            true

          case m: ElectricCurrent =>
            builder.add[ElectricCurrent](
              new EKeyType[ElectricCurrent](k), 
              t.asInstanceOf[EProperty[ElectricCurrent]])
            true
          case m: Capacitance =>
            builder.add[Capacitance](
              new EKeyType[Capacitance](k), 
              t.asInstanceOf[EProperty[Capacitance]])
            true
          case m: Conductivity =>
            builder.add[Conductivity](
              new EKeyType[Conductivity](k), 
              t.asInstanceOf[EProperty[Conductivity]])
            true
          case m: ElectricCharge =>
            builder.add[ElectricCharge](
              new EKeyType[ElectricCharge](k), 
              t.asInstanceOf[EProperty[ElectricCharge]])
            true
          case m: ElectricPotential =>
            builder.add[ElectricPotential](
              new EKeyType[ElectricPotential](k), 
              t.asInstanceOf[EProperty[ElectricPotential]])
            true
          case m: ElectricalConductance =>
            builder.add[ElectricalConductance](
              new EKeyType[ElectricalConductance](k), 
              t.asInstanceOf[EProperty[ElectricalConductance]])
            true
          case m: ElectricalResistance =>
            builder.add[ElectricalResistance](
              new EKeyType[ElectricalResistance](k), 
              t.asInstanceOf[EProperty[ElectricalResistance]])
            true
          case m: Inductance =>
            builder.add[Inductance](
              new EKeyType[Inductance](k), 
              t.asInstanceOf[EProperty[Inductance]])
            true
          case m: MagneticFlux =>
            builder.add[MagneticFlux](
              new EKeyType[MagneticFlux](k), 
              t.asInstanceOf[EProperty[MagneticFlux]])
            true
          case m: MagneticFluxDensity =>
            builder.add[MagneticFluxDensity](
              new EKeyType[MagneticFluxDensity](k), 
              t.asInstanceOf[EProperty[MagneticFluxDensity]])
            true
          case m: Resistivity =>
            builder.add[Resistivity](
              new EKeyType[Resistivity](k), 
              t.asInstanceOf[EProperty[Resistivity]])
            true

          case e: Energy =>
            builder.add[Energy](
              new EKeyType[Energy](k), t.asInstanceOf[EProperty[Energy]])
            true
          case m: PowerDensity =>
            builder.add[PowerDensity](
              new EKeyType[PowerDensity](k), 
              t.asInstanceOf[EProperty[PowerDensity]])
            true
          case m: EnergyDensity =>
            builder.add[EnergyDensity](
              new EKeyType[EnergyDensity](k), 
              t.asInstanceOf[EProperty[EnergyDensity]])
            true
          case m: Power =>
            builder.add[Power](
              new EKeyType[Power](k), t.asInstanceOf[EProperty[Power]])
            true
          case m: PowerRamp =>
            builder.add[PowerRamp](
              new EKeyType[PowerRamp](k), 
              t.asInstanceOf[EProperty[PowerRamp]])
            true
          case m: SpecificEnergy =>
            builder.add[SpecificEnergy](
              new EKeyType[SpecificEnergy](k), 
              t.asInstanceOf[EProperty[SpecificEnergy]])
            true
          case m: MolarEnergy =>
            builder.add[MolarEnergy](
              new EKeyType[MolarEnergy](k), 
              t.asInstanceOf[EProperty[MolarEnergy]])
            true

          case m: DataRate =>
            builder.add[DataRate](
              new EKeyType[DataRate](k), t.asInstanceOf[EProperty[DataRate]])
            true
          case m: Information =>
            builder.add[Information](
              new EKeyType[Information](k), 
              t.asInstanceOf[EProperty[Information]])
            true

          case m: Money =>
            builder.add[Money](
              new EKeyType[Money](k), t.asInstanceOf[EProperty[Money]])
            true

          case m: AreaDensity =>
            builder.add[AreaDensity](
              new EKeyType[AreaDensity](k), 
              t.asInstanceOf[EProperty[AreaDensity]])
            true
          case d: Density =>
            builder.add[Density](
              new EKeyType[Density](k), t.asInstanceOf[EProperty[Density]])
            true
          case m: Mass =>
            builder.add[Mass](
              new EKeyType[Mass](k), t.asInstanceOf[EProperty[Mass]])
            true
          case m: ChemicalAmount =>
            builder.add[ChemicalAmount](
              new EKeyType[ChemicalAmount](k), 
              t.asInstanceOf[EProperty[ChemicalAmount]])
            true

          case m: Acceleration =>
            builder.add[Acceleration](
              new EKeyType[Acceleration](k), 
              t.asInstanceOf[EProperty[Acceleration]])
            true
          case m: AngularAcceleration =>
            builder.add[AngularAcceleration](
              new EKeyType[AngularAcceleration](k), 
              t.asInstanceOf[EProperty[AngularAcceleration]])
            true
          case m: AngularVelocity =>
            builder.add[AngularVelocity](
              new EKeyType[AngularVelocity](k), 
              t.asInstanceOf[EProperty[AngularVelocity]])
            true
          case m: Force =>
            builder.add[Force](
              new EKeyType[Force](k), t.asInstanceOf[EProperty[Force]])
            true
          case m: Jerk =>
            builder.add[Jerk](
              new EKeyType[Jerk](k), t.asInstanceOf[EProperty[Jerk]])
            true
          case m: MassFlow =>
            builder.add[MassFlow](
              new EKeyType[MassFlow](k), t.asInstanceOf[EProperty[MassFlow]])
            true
          case m: Momentum =>
            builder.add[Momentum](
              new EKeyType[Momentum](k), t.asInstanceOf[EProperty[Momentum]])
            true
          case m: Pressure =>
            builder.add[Pressure](
              new EKeyType[Pressure](k), t.asInstanceOf[EProperty[Pressure]])
            true
          case m: PressureChange =>
            builder.add[PressureChange](
              new EKeyType[PressureChange](k), 
              t.asInstanceOf[EProperty[PressureChange]])
            true
          case m: Velocity =>
            builder.add[Velocity](
              new EKeyType[Velocity](k), t.asInstanceOf[EProperty[Velocity]])
            true
          case m: VolumeFlow =>
            builder.add[VolumeFlow](
              new EKeyType[VolumeFlow](k), 
              t.asInstanceOf[EProperty[VolumeFlow]])
            true
          case m: Yank =>
            builder.add[Yank](
              new EKeyType[Yank](k), t.asInstanceOf[EProperty[Yank]])
            true

          case m: Illuminance =>
            builder.add[Illuminance](
              new EKeyType[Illuminance](k), 
              t.asInstanceOf[EProperty[Illuminance]])
            true
          case m: Luminance =>
            builder.add[Luminance](
              new EKeyType[Luminance](k), t.asInstanceOf[EProperty[Luminance]])
            true
          case m: LuminousEnergy =>
            builder.add[LuminousEnergy](
              new EKeyType[LuminousEnergy](k), 
              t.asInstanceOf[EProperty[LuminousEnergy]])
            true
          case m: LuminousExposure =>
            builder.add[LuminousExposure](
              new EKeyType[LuminousExposure](k), 
              t.asInstanceOf[EProperty[LuminousExposure]])
            true
          case m: LuminousFlux =>
            builder.add[LuminousFlux](
              new EKeyType[LuminousFlux](k), 
              t.asInstanceOf[EProperty[LuminousFlux]])
            true
          case m: LuminousIntensity =>
            builder.add[LuminousFlux](
              new EKeyType[LuminousFlux](k), 
              t.asInstanceOf[EProperty[LuminousFlux]])
            true

          case m: Irradiance =>
            builder.add[Irradiance](
              new EKeyType[Irradiance](k), 
              t.asInstanceOf[EProperty[Irradiance]])
            true
          case m: Radiance =>
            builder.add[Radiance](
              new EKeyType[Radiance](k), t.asInstanceOf[EProperty[Radiance]])
            true
          case m: SpectralIntensity =>
            builder.add[SpectralIntensity](
              new EKeyType[SpectralIntensity](k), 
              t.asInstanceOf[EProperty[SpectralIntensity]])
            true
          case m: SpectralIrradiance =>
            builder.add[SpectralIrradiance](
              new EKeyType[SpectralIrradiance](k), 
              t.asInstanceOf[EProperty[SpectralIrradiance]])
            true
          case m: SpectralPower =>
            builder.add[SpectralPower](
              new EKeyType[SpectralPower](k), 
              t.asInstanceOf[EProperty[SpectralPower]])
            true
          case m: Activity =>
            builder.add[Activity](
              new EKeyType[Activity](k), t.asInstanceOf[EProperty[Activity]])
            true
          case m: ParticleFlux =>
            builder.add[ParticleFlux](
              new EKeyType[ParticleFlux](k), 
              t.asInstanceOf[EProperty[ParticleFlux]])
            true
          case m: Dose =>
            builder.add[Dose](
              new EKeyType[Dose](k), t.asInstanceOf[EProperty[Dose]])
            true
          case m: AreaTime =>
            builder.add[AreaTime](
              new EKeyType[AreaTime](k), t.asInstanceOf[EProperty[AreaTime]])
            true

          case m: Angle =>
            builder.add[Angle](
              new EKeyType[Angle](k), t.asInstanceOf[EProperty[Angle]])
            true
          case m: Length =>
            builder.add[Length](
              new EKeyType[Length](k), t.asInstanceOf[EProperty[Length]])
            true
          case m: Area =>
            builder.add[Area](
              new EKeyType[Area](k), t.asInstanceOf[EProperty[Area]])
            true
          case m: Volume =>
            builder.add[Volume](
              new EKeyType[Volume](k), t.asInstanceOf[EProperty[Volume]])
            true
          case m: SolidAngle =>
            builder.add[SolidAngle](
              new EKeyType[SolidAngle](k), 
              t.asInstanceOf[EProperty[SolidAngle]])
            true

          case te: Temperature =>
            builder.add[Temperature](
              new EKeyType[Temperature](k), 
              t.asInstanceOf[EProperty[Temperature]])
            true
          case m: ThermalCapacity =>
            builder.add[ThermalCapacity](
              new EKeyType[ThermalCapacity](k), 
              t.asInstanceOf[EProperty[ThermalCapacity]])
            true

          case e: Time =>
            builder.add[Time](
              new EKeyType[Time](k), t.asInstanceOf[EProperty[Time]])
            true
          case m: Frequency =>
            builder.add[Frequency](
              new EKeyType[Frequency](k), 
              t.asInstanceOf[EProperty[Frequency]])
            true
          case m: TimeSquared =>
            builder.add[TimeSquared](
              new EKeyType[TimeSquared](k), 
              t.asInstanceOf[EProperty[TimeSquared]])
            true

          case p => false
        }
        case _ => assert(false); false
      }
  }

  delegates += SigFigsTerraExtensible
}
