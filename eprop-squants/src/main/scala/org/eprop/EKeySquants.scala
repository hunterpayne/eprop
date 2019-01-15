
package org.eprop

import shapeless.HMap

import squants.Dimensionless
import squants.electro.{ 
  ElectricCurrent, Capacitance, Conductivity, ElectricCharge, 
  ElectricPotential, ElectricalConductance, ElectricalResistance, Inductance, 
  MagneticFlux, MagneticFluxDensity, Resistivity }
import squants.energy.{ 
  Energy, PowerDensity, EnergyDensity, Power, PowerRamp, SpecificEnergy }
import squants.market.Money
import squants.mass.{ AreaDensity, Density, Mass, ChemicalAmount }
import squants.motion.{ 
  Acceleration, AngularVelocity, Force, Jerk, MassFlow, Momentum, Pressure, 
  PressureChange, Velocity, VolumeFlow, Yank }
import squants.photo.{ 
  Illuminance, Luminance, LuminousEnergy, LuminousExposure, LuminousFlux, 
  LuminousIntensity }
import squants.radio.{ 
  Irradiance, Radiance, SpectralIntensity, SpectralIrradiance, SpectralPower }
import squants.space.{ Angle, Area, Length, Volume, SolidAngle }
import squants.thermal.{ Temperature, ThermalCapacity } 
import squants.time.{ Time, Frequency, TimeSquared }

/**
  * a scope containing all the implicit type conversions necessary to
  * make the as method of the property object which generates the EProperty
  * which can be casted to a tuple suitable to be added to a HMap
  */
object EKeySquants {

  import EKey._

  // declarations and type conversions necessary to store the EKeys into
  // a shapeless.HMap
  implicit val dimensionlessElemKeyToValue = 
    new PropMap[EKeyType[Dimensionless], Dimensionless]
  implicit val opDimensionlessElemKeyToValue =
    new PropMap[EKeyType[Option[Dimensionless]], Option[Dimensionless]]

  implicit val electricCurrentElemKeyToValue = 
    new PropMap[EKeyType[ElectricCurrent], ElectricCurrent]
  implicit val opElectricCurrentElemKeyToValue =
    new PropMap[EKeyType[Option[ElectricCurrent]], Option[ElectricCurrent]]
  implicit val capacitanceElemKeyToValue = 
    new PropMap[EKeyType[Capacitance], Capacitance]
  implicit val opCapacitanceElemKeyToValue =
    new PropMap[EKeyType[Option[Capacitance]], Option[Capacitance]]
  implicit val conductivityElemKeyToValue = 
    new PropMap[EKeyType[Conductivity], Conductivity]
  implicit val opConductivityElemKeyToValue =
    new PropMap[EKeyType[Option[Conductivity]], Option[Conductivity]]
  implicit val electricChargeElemKeyToValue = 
    new PropMap[EKeyType[ElectricCharge], ElectricCharge]
  implicit val opElectricChargeElemKeyToValue =
    new PropMap[EKeyType[Option[ElectricCharge]], Option[ElectricCharge]]
  implicit val electricPotentialElemKeyToValue = 
    new PropMap[EKeyType[ElectricPotential], ElectricPotential]
  implicit val opElectricPotentialElemKeyToValue =
    new PropMap[EKeyType[Option[ElectricPotential]], Option[ElectricPotential]]
  implicit val electricalConductanceElemKeyToValue = 
    new PropMap[EKeyType[ElectricalConductance], ElectricalConductance]
  implicit val opElectricalConductanceElemKeyToValue =
    new PropMap[
      EKeyType[Option[ElectricalConductance]], Option[ElectricalConductance]]
  implicit val electricalResistanceElemKeyToValue = 
    new PropMap[EKeyType[ElectricalResistance], ElectricalResistance]
  implicit val opElectricalResistanceElemKeyToValue =
    new PropMap[
      EKeyType[Option[ElectricalResistance]], Option[ElectricalResistance]]
  implicit val inductanceElemKeyToValue = 
    new PropMap[EKeyType[Inductance], Inductance]
  implicit val opInductanceElemKeyToValue =
    new PropMap[EKeyType[Option[Inductance]], Option[Inductance]]
  implicit val magneticFluxElemKeyToValue = 
    new PropMap[EKeyType[MagneticFlux], MagneticFlux]
  implicit val opMagneticFluxElemKeyToValue =
    new PropMap[EKeyType[Option[MagneticFlux]], Option[MagneticFlux]]
  implicit val magneticFluxDensityElemKeyToValue = 
    new PropMap[EKeyType[MagneticFluxDensity], MagneticFluxDensity]
  implicit val opMagneticFluxDensityElemKeyToValue =
    new PropMap[
      EKeyType[Option[MagneticFluxDensity]], Option[MagneticFluxDensity]]
  implicit val resistivityElemKeyToValue = 
    new PropMap[EKeyType[Resistivity], Resistivity]
  implicit val opResistivityElemKeyToValue =
    new PropMap[EKeyType[Option[Resistivity]], Option[Resistivity]]

  implicit val energyElemKeyToValue = new PropMap[EKeyType[Energy], Energy]
  implicit val opEnergyElemKeyToValue =
    new PropMap[EKeyType[Option[Energy]], Option[Energy]]
  implicit val powerDensityElemKeyToValue = 
    new PropMap[EKeyType[PowerDensity], PowerDensity]
  implicit val opPowerDensityElemKeyToValue =
    new PropMap[EKeyType[Option[PowerDensity]], Option[PowerDensity]]
  implicit val energyDensityElemKeyToValue = 
    new PropMap[EKeyType[EnergyDensity], EnergyDensity]
  implicit val opEnergyDensityElemKeyToValue =
    new PropMap[EKeyType[Option[EnergyDensity]], Option[EnergyDensity]]
  implicit val powerElemKeyToValue = new PropMap[EKeyType[Power], Power]
  implicit val opPowerElemKeyToValue =
    new PropMap[EKeyType[Option[Power]], Option[Power]]
  implicit val powerRampElemKeyToValue = 
    new PropMap[EKeyType[PowerRamp], PowerRamp]
  implicit val opPowerRampElemKeyToValue =
    new PropMap[EKeyType[Option[PowerRamp]], Option[PowerRamp]]
  implicit val specificEnergyElemKeyToValue = 
    new PropMap[EKeyType[SpecificEnergy], SpecificEnergy]
  implicit val opSpecificEnergyElemKeyToValue =
    new PropMap[EKeyType[Option[SpecificEnergy]], Option[SpecificEnergy]]

  implicit val moneyElemKeyToValue = new PropMap[EKeyType[Money], Money]
  implicit val opMoneyElemKeyToValue =
    new PropMap[EKeyType[Option[Money]], Option[Money]]

  implicit val areaDensityElemKeyToValue = 
    new PropMap[EKeyType[AreaDensity], AreaDensity]
  implicit val opAreaDensityElemKeyToValue =
    new PropMap[EKeyType[Option[AreaDensity]], Option[AreaDensity]]
  implicit val densityElemKeyToValue = 
    new PropMap[EKeyType[Density], Density]
  implicit val opDensityElemKeyToValue =
    new PropMap[EKeyType[Option[Density]], Option[Density]]
  implicit val massElemKeyToValue = new PropMap[EKeyType[Mass], Mass]
  implicit val opMassElemKeyToValue =
    new PropMap[EKeyType[Option[Mass]], Option[Mass]]
  implicit val chemicalAmountElemKeyToValue = 
    new PropMap[EKeyType[ChemicalAmount], ChemicalAmount]
  implicit val opChemicalAmountElemKeyToValue =
    new PropMap[EKeyType[Option[ChemicalAmount]], Option[ChemicalAmount]]

  implicit val accelerationElemKeyToValue = 
    new PropMap[EKeyType[Acceleration], Acceleration]
  implicit val opAccelerationElemKeyToValue =
    new PropMap[EKeyType[Option[Acceleration]], Option[Acceleration]]
  implicit val angularVelocityElemKeyToValue = 
    new PropMap[EKeyType[AngularVelocity], AngularVelocity]
  implicit val opAngularVelocityElemKeyToValue =
    new PropMap[EKeyType[Option[AngularVelocity]], Option[AngularVelocity]]
  implicit val forceElemKeyToValue = new PropMap[EKeyType[Force], Force]
  implicit val opForceElemKeyToValue =
    new PropMap[EKeyType[Option[Force]], Option[Force]]
  implicit val jerkElemKeyToValue = new PropMap[EKeyType[Jerk], Jerk]
  implicit val opJerkElemKeyToValue =
    new PropMap[EKeyType[Option[Jerk]], Option[Jerk]]
  implicit val massFlowElemKeyToValue = 
    new PropMap[EKeyType[MassFlow], MassFlow]
  implicit val opMassFlowElemKeyToValue =
    new PropMap[EKeyType[Option[MassFlow]], Option[MassFlow]]
  implicit val momentumElemKeyToValue = 
    new PropMap[EKeyType[Momentum], Momentum]
  implicit val opMomentumElemKeyToValue =
    new PropMap[EKeyType[Option[Momentum]], Option[Momentum]]
  implicit val pressureChangeElemKeyToValue = 
    new PropMap[EKeyType[PressureChange], PressureChange]
  implicit val opPressureChangeElemKeyToValue =
    new PropMap[EKeyType[Option[PressureChange]], Option[PressureChange]]
  implicit val pressureElemKeyToValue = 
    new PropMap[EKeyType[Pressure], Pressure]
  implicit val opPressureElemKeyToValue =
    new PropMap[EKeyType[Option[Pressure]], Option[Pressure]]
  implicit val velocityElemKeyToValue = 
    new PropMap[EKeyType[Velocity], Velocity]
  implicit val opVelocityElemKeyToValue =
    new PropMap[EKeyType[Option[Velocity]], Option[Velocity]]
  implicit val volumeFlowElemKeyToValue = 
    new PropMap[EKeyType[VolumeFlow], VolumeFlow]
  implicit val opVolumeFlowElemKeyToValue =
    new PropMap[EKeyType[Option[VolumeFlow]], Option[VolumeFlow]]
  implicit val yankElemKeyToValue = new PropMap[EKeyType[Yank], Yank]
  implicit val opYankElemKeyToValue =
    new PropMap[EKeyType[Option[Yank]], Option[Yank]]

  implicit val illuminanceElemKeyToValue = 
    new PropMap[EKeyType[Illuminance], Illuminance]
  implicit val opIlluminanceElemKeyToValue =
    new PropMap[EKeyType[Option[Illuminance]], Option[Illuminance]]
  implicit val luminanceElemKeyToValue = 
    new PropMap[EKeyType[Luminance], Luminance]
  implicit val opLuminanceElemKeyToValue =
    new PropMap[EKeyType[Option[Luminance]], Option[Luminance]]
  implicit val luminousEnergyElemKeyToValue = 
    new PropMap[EKeyType[LuminousEnergy], LuminousEnergy]
  implicit val opLuminousEnergyElemKeyToValue =
    new PropMap[EKeyType[Option[LuminousEnergy]], Option[LuminousEnergy]]
  implicit val luminousExposureElemKeyToValue = 
    new PropMap[EKeyType[LuminousExposure], LuminousExposure]
  implicit val opLuminousExposureElemKeyToValue =
    new PropMap[EKeyType[Option[LuminousExposure]], Option[LuminousExposure]]
  implicit val luminousFluxElemKeyToValue = 
    new PropMap[EKeyType[LuminousFlux], LuminousFlux]
  implicit val opLuminousFluxElemKeyToValue =
    new PropMap[EKeyType[Option[LuminousFlux]], Option[LuminousFlux]]
  implicit val luminousIntensityElemKeyToValue = 
    new PropMap[EKeyType[LuminousIntensity], LuminousIntensity]
  implicit val opLuminousIntensityElemKeyToValue =
    new PropMap[EKeyType[Option[LuminousIntensity]], Option[LuminousIntensity]]

  implicit val irradianceElemKeyToValue = 
    new PropMap[EKeyType[Irradiance], Irradiance]
  implicit val opIrradianceElemKeyToValue =
    new PropMap[EKeyType[Option[Irradiance]], Option[Irradiance]]
  implicit val radianceElemKeyToValue = 
    new PropMap[EKeyType[Radiance], Radiance]
  implicit val opRadianceElemKeyToValue =
    new PropMap[EKeyType[Option[Radiance]], Option[Radiance]]
  implicit val spectralIntensityElemKeyToValue = 
    new PropMap[EKeyType[SpectralIntensity], SpectralIntensity]
  implicit val opSpectralIntensityElemKeyToValue =
    new PropMap[EKeyType[Option[SpectralIntensity]], Option[SpectralIntensity]]
  implicit val spectralIrradianceElemKeyToValue = 
    new PropMap[EKeyType[SpectralIrradiance], SpectralIrradiance]
  implicit val opSpectralIrradianceElemKeyToValue =
    new PropMap[
      EKeyType[Option[SpectralIrradiance]], Option[SpectralIrradiance]]
  implicit val spectralPowerElemKeyToValue = 
    new PropMap[EKeyType[SpectralPower], SpectralPower]
  implicit val opSpectralPowerElemKeyToValue =
    new PropMap[EKeyType[Option[SpectralPower]], Option[SpectralPower]]

  implicit val angleElemKeyToValue = new PropMap[EKeyType[Angle], Angle]
  implicit val opAngleElemKeyToValue =
    new PropMap[EKeyType[Option[Angle]], Option[Angle]]
  implicit val lengthElemKeyToValue = new PropMap[EKeyType[Length], Length]
  implicit val opLengthElemKeyToValue =
    new PropMap[EKeyType[Option[Length]], Option[Length]]
  implicit val areaElemKeyToValue = new PropMap[EKeyType[Area], Area]
  implicit val opAreaElemKeyToValue =
    new PropMap[EKeyType[Option[Area]], Option[Area]]
  implicit val volElemKeyToValue = new PropMap[EKeyType[Volume], Volume]
  implicit val opVolElemKeyToValue =
    new PropMap[EKeyType[Option[Volume]], Option[Volume]]
  implicit val solidAngleElemKeyToValue = 
    new PropMap[EKeyType[SolidAngle], SolidAngle]
  implicit val opSolidAngleElemKeyToValue =
    new PropMap[EKeyType[Option[SolidAngle]], Option[SolidAngle]]

  implicit val tempElemKeyToValue = 
    new PropMap[EKeyType[Temperature], Temperature]
  implicit val opTempElemKeyToValue =
    new PropMap[EKeyType[Option[Temperature]], Option[Temperature]]
  implicit val thermalCapacityElemKeyToValue = 
    new PropMap[EKeyType[ThermalCapacity], ThermalCapacity]
  implicit val opThermalCapacityElemKeyToValue =
    new PropMap[EKeyType[Option[ThermalCapacity]], Option[ThermalCapacity]]

  implicit val timeElemKeyToValue = new PropMap[EKeyType[Time], Time]
  implicit val opTimeElemKeyToValue =
    new PropMap[EKeyType[Option[Time]], Option[Time]]
  implicit val frequencyElemKeyToValue = 
    new PropMap[EKeyType[Frequency], Frequency]
  implicit val opFrequencyElemKeyToValue =
    new PropMap[EKeyType[Option[Frequency]], Option[Frequency]]
  implicit val timeSquaredElemKeyToValue = 
    new PropMap[EKeyType[TimeSquared], TimeSquared]
  implicit val opTimeSquaredElemKeyToValue =
    new PropMap[EKeyType[Option[TimeSquared]], Option[TimeSquared]]


  // implicit type conversions
  implicit val dimensionlessConv: EKey[Dimensionless] =
    new EKey[Dimensionless] {
      def as(symbol: Symbol, value: Dimensionless): EProperty[Dimensionless] =
        EProperty[Dimensionless](symbol, value)
      def as(symbol: EKeyType[Dimensionless], value: Dimensionless): 
          EProperty[Dimensionless] = 
        EProperty[Dimensionless](symbol.sym, value)
    }

  implicit val opDimensionlessConv: EKey[Option[Dimensionless]] =
    new EKey[Option[Dimensionless]] {
      def as(symbol: Symbol, value: Option[Dimensionless]): 
          EProperty[Option[Dimensionless]] =
        EProperty[Option[Dimensionless]](symbol, value)
      def as(
        symbol: EKeyType[Option[Dimensionless]], value: Option[Dimensionless]):
          EProperty[Option[Dimensionless]] = 
        EProperty[Option[Dimensionless]](symbol.sym, value)
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

  implicit val opElectricCurrentConv: EKey[Option[ElectricCurrent]] =
    new EKey[Option[ElectricCurrent]] {
      def as(symbol: Symbol, value: Option[ElectricCurrent]): 
          EProperty[Option[ElectricCurrent]] =
        EProperty[Option[ElectricCurrent]](symbol, value)
      def as(
        symbol: EKeyType[Option[ElectricCurrent]], 
        value: Option[ElectricCurrent]):
          EProperty[Option[ElectricCurrent]] = 
        EProperty[Option[ElectricCurrent]](symbol.sym, value)
    }

  implicit val capacitanceConv: EKey[Capacitance] =
    new EKey[Capacitance] {
      def as(symbol: Symbol, value: Capacitance): EProperty[Capacitance] =
        EProperty[Capacitance](symbol, value)
      def as(symbol: EKeyType[Capacitance], value: Capacitance): 
          EProperty[Capacitance] = 
        EProperty[Capacitance](symbol.sym, value)
    }

  implicit val opCapacitanceConv: EKey[Option[Capacitance]] =
    new EKey[Option[Capacitance]] {
      def as(symbol: Symbol, value: Option[Capacitance]): 
          EProperty[Option[Capacitance]] =
        EProperty[Option[Capacitance]](symbol, value)
      def as(symbol: EKeyType[Option[Capacitance]], value: Option[Capacitance]):
          EProperty[Option[Capacitance]] = 
        EProperty[Option[Capacitance]](symbol.sym, value)
    }

  implicit val conductivityConv: EKey[Conductivity] =
    new EKey[Conductivity] {
      def as(symbol: Symbol, value: Conductivity): EProperty[Conductivity] =
        EProperty[Conductivity](symbol, value)
      def as(symbol: EKeyType[Conductivity], value: Conductivity): 
          EProperty[Conductivity] = 
        EProperty[Conductivity](symbol.sym, value)
    }

  implicit val opConductivityConv: EKey[Option[Conductivity]] =
    new EKey[Option[Conductivity]] {
      def as(symbol: Symbol, value: Option[Conductivity]): 
          EProperty[Option[Conductivity]] =
        EProperty[Option[Conductivity]](symbol, value)
      def as(
        symbol: EKeyType[Option[Conductivity]], value: Option[Conductivity]):
          EProperty[Option[Conductivity]] = 
        EProperty[Option[Conductivity]](symbol.sym, value)
    }

  implicit val electricChargeConv: EKey[ElectricCharge] =
    new EKey[ElectricCharge] {
      def as(symbol: Symbol, value: ElectricCharge): EProperty[ElectricCharge] =
        EProperty[ElectricCharge](symbol, value)
      def as(symbol: EKeyType[ElectricCharge], value: ElectricCharge): 
          EProperty[ElectricCharge] = 
        EProperty[ElectricCharge](symbol.sym, value)
    }

  implicit val opElectricChargeConv: EKey[Option[ElectricCharge]] =
    new EKey[Option[ElectricCharge]] {
      def as(symbol: Symbol, value: Option[ElectricCharge]): 
          EProperty[Option[ElectricCharge]] =
        EProperty[Option[ElectricCharge]](symbol, value)
      def as(
        symbol: EKeyType[Option[ElectricCharge]], 
        value: Option[ElectricCharge]):
          EProperty[Option[ElectricCharge]] = 
        EProperty[Option[ElectricCharge]](symbol.sym, value)
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

  implicit val opElectricPotentialConv: EKey[Option[ElectricPotential]] =
    new EKey[Option[ElectricPotential]] {
      def as(symbol: Symbol, value: Option[ElectricPotential]): 
          EProperty[Option[ElectricPotential]] =
        EProperty[Option[ElectricPotential]](symbol, value)
      def as(
        symbol: EKeyType[Option[ElectricPotential]], 
        value: Option[ElectricPotential]):
          EProperty[Option[ElectricPotential]] = 
        EProperty[Option[ElectricPotential]](symbol.sym, value)
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

  implicit val opElectricalConductanceConv: 
      EKey[Option[ElectricalConductance]] =
    new EKey[Option[ElectricalConductance]] {
      def as(symbol: Symbol, value: Option[ElectricalConductance]): 
          EProperty[Option[ElectricalConductance]] =
        EProperty[Option[ElectricalConductance]](symbol, value)
      def as(
        symbol: EKeyType[Option[ElectricalConductance]], 
        value: Option[ElectricalConductance]):
          EProperty[Option[ElectricalConductance]] = 
        EProperty[Option[ElectricalConductance]](symbol.sym, value)
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

  implicit val opElectricalResistanceConv: EKey[Option[ElectricalResistance]] =
    new EKey[Option[ElectricalResistance]] {
      def as(symbol: Symbol, value: Option[ElectricalResistance]): 
          EProperty[Option[ElectricalResistance]] =
        EProperty[Option[ElectricalResistance]](symbol, value)
      def as(
        symbol: EKeyType[Option[ElectricalResistance]], 
        value: Option[ElectricalResistance]):
          EProperty[Option[ElectricalResistance]] = 
        EProperty[Option[ElectricalResistance]](symbol.sym, value)
    }

  implicit val inductanceConv: EKey[Inductance] =
    new EKey[Inductance] {
      def as(symbol: Symbol, value: Inductance): EProperty[Inductance] =
        EProperty[Inductance](symbol, value)
      def as(symbol: EKeyType[Inductance], value: Inductance): 
          EProperty[Inductance] = 
        EProperty[Inductance](symbol.sym, value)
    }

  implicit val opInductanceConv: EKey[Option[Inductance]] =
    new EKey[Option[Inductance]] {
      def as(symbol: Symbol, value: Option[Inductance]): 
          EProperty[Option[Inductance]] =
        EProperty[Option[Inductance]](symbol, value)
      def as(symbol: EKeyType[Option[Inductance]], value: Option[Inductance]): 
          EProperty[Option[Inductance]] = 
        EProperty[Option[Inductance]](symbol.sym, value)
    }

  implicit val magneticFluxConv: EKey[MagneticFlux] =
    new EKey[MagneticFlux] {
      def as(symbol: Symbol, value: MagneticFlux): EProperty[MagneticFlux] =
        EProperty[MagneticFlux](symbol, value)
      def as(symbol: EKeyType[MagneticFlux], value: MagneticFlux): 
          EProperty[MagneticFlux] = 
        EProperty[MagneticFlux](symbol.sym, value)
    }

  implicit val opMagneticFluxConv: EKey[Option[MagneticFlux]] =
    new EKey[Option[MagneticFlux]] {
      def as(symbol: Symbol, value: Option[MagneticFlux]): 
          EProperty[Option[MagneticFlux]] =
        EProperty[Option[MagneticFlux]](symbol, value)
      def as(
        symbol: EKeyType[Option[MagneticFlux]], value: Option[MagneticFlux]):
          EProperty[Option[MagneticFlux]] = 
        EProperty[Option[MagneticFlux]](symbol.sym, value)
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

  implicit val opMagneticFluxDensityConv: EKey[Option[MagneticFluxDensity]] =
    new EKey[Option[MagneticFluxDensity]] {
      def as(symbol: Symbol, value: Option[MagneticFluxDensity]): 
          EProperty[Option[MagneticFluxDensity]] =
        EProperty[Option[MagneticFluxDensity]](symbol, value)
      def as(
        symbol: EKeyType[Option[MagneticFluxDensity]], 
        value: Option[MagneticFluxDensity]):
          EProperty[Option[MagneticFluxDensity]] = 
        EProperty[Option[MagneticFluxDensity]](symbol.sym, value)
    }

  implicit val resistivityConv: EKey[Resistivity] =
    new EKey[Resistivity] {
      def as(symbol: Symbol, value: Resistivity): EProperty[Resistivity] =
        EProperty[Resistivity](symbol, value)
      def as(symbol: EKeyType[Resistivity], value: Resistivity): 
          EProperty[Resistivity] = 
        EProperty[Resistivity](symbol.sym, value)
    }

  implicit val opResistivityConv: EKey[Option[Resistivity]] =
    new EKey[Option[Resistivity]] {
      def as(symbol: Symbol, value: Option[Resistivity]): 
          EProperty[Option[Resistivity]] =
        EProperty[Option[Resistivity]](symbol, value)
      def as(symbol: EKeyType[Option[Resistivity]], value: Option[Resistivity]):
          EProperty[Option[Resistivity]] = 
        EProperty[Option[Resistivity]](symbol.sym, value)
    }


  implicit val energyConv: EKey[Energy] =
    new EKey[Energy] {
      def as(symbol: Symbol, value: Energy): EProperty[Energy] = 
        EProperty[Energy](symbol, value)
      def as(symbol: EKeyType[Energy], value: Energy): 
          EProperty[Energy] = 
        EProperty[Energy](symbol.sym, value)
    }

  implicit val opEnergyConv: EKey[Option[Energy]] =
    new EKey[Option[Energy]] {
      def as(symbol: Symbol, value: Option[Energy]): 
          EProperty[Option[Energy]] =
        EProperty[Option[Energy]](symbol, value)
      def as(symbol: EKeyType[Option[Energy]], value: Option[Energy]): 
          EProperty[Option[Energy]] = 
        EProperty[Option[Energy]](symbol.sym, value)
    }

  implicit val powerDensityConv: EKey[PowerDensity] =
    new EKey[PowerDensity] {
      def as(symbol: Symbol, value: PowerDensity): EProperty[PowerDensity] = 
        EProperty[PowerDensity](symbol, value)
      def as(symbol: EKeyType[PowerDensity], value: PowerDensity): 
          EProperty[PowerDensity] = 
        EProperty[PowerDensity](symbol.sym, value)
    }

  implicit val opPowerDensityConv: EKey[Option[PowerDensity]] =
    new EKey[Option[PowerDensity]] {
      def as(symbol: Symbol, value: Option[PowerDensity]): 
          EProperty[Option[PowerDensity]] =
        EProperty[Option[PowerDensity]](symbol, value)
      def as(
        symbol: EKeyType[Option[PowerDensity]], value: Option[PowerDensity]):
          EProperty[Option[PowerDensity]] = 
        EProperty[Option[PowerDensity]](symbol.sym, value)
    }

  implicit val energyDensityConv: EKey[EnergyDensity] =
    new EKey[EnergyDensity] {
      def as(symbol: Symbol, value: EnergyDensity): EProperty[EnergyDensity] = 
        EProperty[EnergyDensity](symbol, value)
      def as(symbol: EKeyType[EnergyDensity], value: EnergyDensity): 
          EProperty[EnergyDensity] = 
        EProperty[EnergyDensity](symbol.sym, value)
    }

  implicit val opEnergyDensityConv: EKey[Option[EnergyDensity]] =
    new EKey[Option[EnergyDensity]] {
      def as(symbol: Symbol, value: Option[EnergyDensity]): 
          EProperty[Option[EnergyDensity]] =
        EProperty[Option[EnergyDensity]](symbol, value)
      def as(
        symbol: EKeyType[Option[EnergyDensity]], value: Option[EnergyDensity]):
          EProperty[Option[EnergyDensity]] = 
        EProperty[Option[EnergyDensity]](symbol.sym, value)
    }

  implicit val powerConv: EKey[Power] =
    new EKey[Power] {
      def as(symbol: Symbol, value: Power): EProperty[Power] = 
        EProperty[Power](symbol, value)
      def as(symbol: EKeyType[Power], value: Power): 
          EProperty[Power] = 
        EProperty[Power](symbol.sym, value)
    }

  implicit val opPowerConv: EKey[Option[Power]] =
    new EKey[Option[Power]] {
      def as(symbol: Symbol, value: Option[Power]): 
          EProperty[Option[Power]] =
        EProperty[Option[Power]](symbol, value)
      def as(symbol: EKeyType[Option[Power]], value: Option[Power]): 
          EProperty[Option[Power]] = 
        EProperty[Option[Power]](symbol.sym, value)
    }

  implicit val powerRampConv: EKey[PowerRamp] =
    new EKey[PowerRamp] {
      def as(symbol: Symbol, value: PowerRamp): EProperty[PowerRamp] = 
        EProperty[PowerRamp](symbol, value)
      def as(symbol: EKeyType[PowerRamp], value: PowerRamp): 
          EProperty[PowerRamp] = 
        EProperty[PowerRamp](symbol.sym, value)
    }

  implicit val opPowerRampConv: EKey[Option[PowerRamp]] =
    new EKey[Option[PowerRamp]] {
      def as(symbol: Symbol, value: Option[PowerRamp]): 
          EProperty[Option[PowerRamp]] =
        EProperty[Option[PowerRamp]](symbol, value)
      def as(symbol: EKeyType[Option[PowerRamp]], value: Option[PowerRamp]): 
          EProperty[Option[PowerRamp]] = 
        EProperty[Option[PowerRamp]](symbol.sym, value)
    }

  implicit val specificEnergyConv: EKey[SpecificEnergy] =
    new EKey[SpecificEnergy] {
      def as(symbol: Symbol, value: SpecificEnergy): EProperty[SpecificEnergy] =
        EProperty[SpecificEnergy](symbol, value)
      def as(symbol: EKeyType[SpecificEnergy], value: SpecificEnergy): 
          EProperty[SpecificEnergy] = 
        EProperty[SpecificEnergy](symbol.sym, value)
    }

  implicit val opSpecificEnergyConv: EKey[Option[SpecificEnergy]] =
    new EKey[Option[SpecificEnergy]] {
      def as(symbol: Symbol, value: Option[SpecificEnergy]): 
          EProperty[Option[SpecificEnergy]] =
        EProperty[Option[SpecificEnergy]](symbol, value)
      def as(
        symbol: EKeyType[Option[SpecificEnergy]], 
        value: Option[SpecificEnergy]):
          EProperty[Option[SpecificEnergy]] = 
        EProperty[Option[SpecificEnergy]](symbol.sym, value)
    }


  implicit val moneyConv: EKey[Money] =
    new EKey[Money] {
      def as(symbol: Symbol, value: Money): EProperty[Money] = 
        EProperty[Money](symbol, value)
      def as(symbol: EKeyType[Money], value: Money): 
          EProperty[Money] = 
        EProperty[Money](symbol.sym, value)
    }

  implicit val opMoneyConv: EKey[Option[Money]] =
    new EKey[Option[Money]] {
      def as(symbol: Symbol, value: Option[Money]): 
          EProperty[Option[Money]] =
        EProperty[Option[Money]](symbol, value)
      def as(symbol: EKeyType[Option[Money]], value: Option[Money]): 
          EProperty[Option[Money]] = 
        EProperty[Option[Money]](symbol.sym, value)
    }


  implicit val areaDensityConv: EKey[AreaDensity] =
    new EKey[AreaDensity] {
      def as(symbol: Symbol, value: AreaDensity): EProperty[AreaDensity] = 
        EProperty[AreaDensity](symbol, value)
      def as(symbol: EKeyType[AreaDensity], value: AreaDensity): 
          EProperty[AreaDensity] = 
        EProperty[AreaDensity](symbol.sym, value)
    }

  implicit val opAreaDensityConv: EKey[Option[AreaDensity]] =
    new EKey[Option[AreaDensity]] {
      def as(symbol: Symbol, value: Option[AreaDensity]): 
          EProperty[Option[AreaDensity]] =
        EProperty[Option[AreaDensity]](symbol, value)
      def as(symbol: EKeyType[Option[AreaDensity]], value: Option[AreaDensity]):
          EProperty[Option[AreaDensity]] = 
        EProperty[Option[AreaDensity]](symbol.sym, value)
    }

  implicit val densityConv: EKey[Density] =
    new EKey[Density] {
      def as(symbol: Symbol, value: Density): EProperty[Density] = 
        EProperty[Density](symbol, value)
      def as(symbol: EKeyType[Density], value: Density): 
          EProperty[Density] =
        EProperty[Density](symbol.sym, value)
    }

  implicit val opDensityConv: EKey[Option[Density]] =
    new EKey[Option[Density]] {
      def as(symbol: Symbol, value: Option[Density]): 
          EProperty[Option[Density]] =
        EProperty[Option[Density]](symbol, value)
      def as(symbol: EKeyType[Option[Density]], value: Option[Density]): 
          EProperty[Option[Density]] =
        EProperty[Option[Density]](symbol.sym, value)
    }

  implicit val massConv: EKey[Mass] =
    new EKey[Mass] {
      def as(symbol: Symbol, value: Mass): EProperty[Mass] = 
        EProperty[Mass](symbol, value)
      def as(symbol: EKeyType[Mass], value: Mass): 
          EProperty[Mass] = 
        EProperty[Mass](symbol.sym, value)
    }

  implicit val opMassConv: EKey[Option[Mass]] =
    new EKey[Option[Mass]] {
      def as(symbol: Symbol, value: Option[Mass]): 
          EProperty[Option[Mass]] =
        EProperty[Option[Mass]](symbol, value)
      def as(symbol: EKeyType[Option[Mass]], value: Option[Mass]): 
          EProperty[Option[Mass]] = 
        EProperty[Option[Mass]](symbol.sym, value)
    }

  implicit val chemicalAmountConv: EKey[ChemicalAmount] =
    new EKey[ChemicalAmount] {
      def as(symbol: Symbol, value: ChemicalAmount): EProperty[ChemicalAmount] =
        EProperty[ChemicalAmount](symbol, value)
      def as(symbol: EKeyType[ChemicalAmount], value: ChemicalAmount): 
          EProperty[ChemicalAmount] = 
        EProperty[ChemicalAmount](symbol.sym, value)
    }

  implicit val opChemicalAmountConv: EKey[Option[ChemicalAmount]] =
    new EKey[Option[ChemicalAmount]] {
      def as(symbol: Symbol, value: Option[ChemicalAmount]): 
          EProperty[Option[ChemicalAmount]] =
        EProperty[Option[ChemicalAmount]](symbol, value)
      def as(
        symbol: EKeyType[Option[ChemicalAmount]], 
        value: Option[ChemicalAmount]):
          EProperty[Option[ChemicalAmount]] = 
        EProperty[Option[ChemicalAmount]](symbol.sym, value)
    }


  implicit val accelerationConv: EKey[Acceleration] =
    new EKey[Acceleration] {
      def as(symbol: Symbol, value: Acceleration): EProperty[Acceleration] =
        EProperty[Acceleration](symbol, value)
      def as(symbol: EKeyType[Acceleration], value: Acceleration): 
          EProperty[Acceleration] = 
        EProperty[Acceleration](symbol.sym, value)
    }

  implicit val opAccelerationConv: EKey[Option[Acceleration]] =
    new EKey[Option[Acceleration]] {
      def as(symbol: Symbol, value: Option[Acceleration]): 
          EProperty[Option[Acceleration]] =
        EProperty[Option[Acceleration]](symbol, value)
      def as(
        symbol: EKeyType[Option[Acceleration]], value: Option[Acceleration]):
          EProperty[Option[Acceleration]] = 
        EProperty[Option[Acceleration]](symbol.sym, value)
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

  implicit val opAngularVelocityConv: EKey[Option[AngularVelocity]] =
    new EKey[Option[AngularVelocity]] {
      def as(symbol: Symbol, value: Option[AngularVelocity]): 
          EProperty[Option[AngularVelocity]] =
        EProperty[Option[AngularVelocity]](symbol, value)
      def as(
        symbol: EKeyType[Option[AngularVelocity]], 
        value: Option[AngularVelocity]):
          EProperty[Option[AngularVelocity]] = 
        EProperty[Option[AngularVelocity]](symbol.sym, value)
    }

  implicit val forceConv: EKey[Force] =
    new EKey[Force] {
      def as(symbol: Symbol, value: Force): EProperty[Force] = 
        EProperty[Force](symbol, value)
      def as(symbol: EKeyType[Force], value: Force): 
          EProperty[Force] = 
        EProperty[Force](symbol.sym, value)
    }

  implicit val opForceConv: EKey[Option[Force]] =
    new EKey[Option[Force]] {
      def as(symbol: Symbol, value: Option[Force]): 
          EProperty[Option[Force]] =
        EProperty[Option[Force]](symbol, value)
      def as(symbol: EKeyType[Option[Force]], value: Option[Force]): 
          EProperty[Option[Force]] = 
        EProperty[Option[Force]](symbol.sym, value)
    }

  implicit val jerkConv: EKey[Jerk] =
    new EKey[Jerk] {
      def as(symbol: Symbol, value: Jerk): EProperty[Jerk] = 
        EProperty[Jerk](symbol, value)
      def as(symbol: EKeyType[Jerk], value: Jerk): 
          EProperty[Jerk] = 
        EProperty[Jerk](symbol.sym, value)
    }

  implicit val opJerkConv: EKey[Option[Jerk]] =
    new EKey[Option[Jerk]] {
      def as(symbol: Symbol, value: Option[Jerk]): 
          EProperty[Option[Jerk]] =
        EProperty[Option[Jerk]](symbol, value)
      def as(symbol: EKeyType[Option[Jerk]], value: Option[Jerk]): 
          EProperty[Option[Jerk]] = 
        EProperty[Option[Jerk]](symbol.sym, value)
    }

  implicit val massFlowConv: EKey[MassFlow] =
    new EKey[MassFlow] {
      def as(symbol: Symbol, value: MassFlow): EProperty[MassFlow] = 
        EProperty[MassFlow](symbol, value)
      def as(symbol: EKeyType[MassFlow], value: MassFlow): 
          EProperty[MassFlow] = 
        EProperty[MassFlow](symbol.sym, value)
    }

  implicit val opMassFlowConv: EKey[Option[MassFlow]] =
    new EKey[Option[MassFlow]] {
      def as(symbol: Symbol, value: Option[MassFlow]): 
          EProperty[Option[MassFlow]] =
        EProperty[Option[MassFlow]](symbol, value)
      def as(symbol: EKeyType[Option[MassFlow]], value: Option[MassFlow]): 
          EProperty[Option[MassFlow]] = 
        EProperty[Option[MassFlow]](symbol.sym, value)
    }

  implicit val momentumConv: EKey[Momentum] =
    new EKey[Momentum] {
      def as(symbol: Symbol, value: Momentum): EProperty[Momentum] = 
        EProperty[Momentum](symbol, value)
      def as(symbol: EKeyType[Momentum], value: Momentum): 
          EProperty[Momentum] = 
        EProperty[Momentum](symbol.sym, value)
    }

  implicit val opMomentumConv: EKey[Option[Momentum]] =
    new EKey[Option[Momentum]] {
      def as(symbol: Symbol, value: Option[Momentum]): 
          EProperty[Option[Momentum]] =
        EProperty[Option[Momentum]](symbol, value)
      def as(symbol: EKeyType[Option[Momentum]], value: Option[Momentum]): 
          EProperty[Option[Momentum]] = 
        EProperty[Option[Momentum]](symbol.sym, value)
    }

  implicit val pressureConv: EKey[Pressure] =
    new EKey[Pressure] {
      def as(symbol: Symbol, value: Pressure): EProperty[Pressure] = 
        EProperty[Pressure](symbol, value)
      def as(symbol: EKeyType[Pressure], value: Pressure): 
          EProperty[Pressure] = 
        EProperty[Pressure](symbol.sym, value)
    }

  implicit val opPressureConv: EKey[Option[Pressure]] =
    new EKey[Option[Pressure]] {
      def as(symbol: Symbol, value: Option[Pressure]): 
          EProperty[Option[Pressure]] =
        EProperty[Option[Pressure]](symbol, value)
      def as(symbol: EKeyType[Option[Pressure]], value: Option[Pressure]): 
          EProperty[Option[Pressure]] = 
        EProperty[Option[Pressure]](symbol.sym, value)
    }

  implicit val pressureChangeConv: EKey[PressureChange] =
    new EKey[PressureChange] {
      def as(symbol: Symbol, value: PressureChange): EProperty[PressureChange] =
        EProperty[PressureChange](symbol, value)
      def as(symbol: EKeyType[PressureChange], value: PressureChange): 
          EProperty[PressureChange] = 
        EProperty[PressureChange](symbol.sym, value)
    }

  implicit val opPressureChangeConv: EKey[Option[PressureChange]] =
    new EKey[Option[PressureChange]] {
      def as(symbol: Symbol, value: Option[PressureChange]): 
          EProperty[Option[PressureChange]] =
        EProperty[Option[PressureChange]](symbol, value)
      def as(
        symbol: EKeyType[Option[PressureChange]], 
        value: Option[PressureChange]):
          EProperty[Option[PressureChange]] = 
        EProperty[Option[PressureChange]](symbol.sym, value)
    }

  implicit val velocityConv: EKey[Velocity] =
    new EKey[Velocity] {
      def as(symbol: Symbol, value: Velocity): EProperty[Velocity] = 
        EProperty[Velocity](symbol, value)
      def as(symbol: EKeyType[Velocity], value: Velocity): 
          EProperty[Velocity] = 
        EProperty[Velocity](symbol.sym, value)
    }

  implicit val opVelocityConv: EKey[Option[Velocity]] =
    new EKey[Option[Velocity]] {
      def as(symbol: Symbol, value: Option[Velocity]): 
          EProperty[Option[Velocity]] =
        EProperty[Option[Velocity]](symbol, value)
      def as(symbol: EKeyType[Option[Velocity]], value: Option[Velocity]): 
          EProperty[Option[Velocity]] = 
        EProperty[Option[Velocity]](symbol.sym, value)
    }

  implicit val volumeFlowConv: EKey[VolumeFlow] =
    new EKey[VolumeFlow] {
      def as(symbol: Symbol, value: VolumeFlow): EProperty[VolumeFlow] = 
        EProperty[VolumeFlow](symbol, value)
      def as(symbol: EKeyType[VolumeFlow], value: VolumeFlow): 
          EProperty[VolumeFlow] = 
        EProperty[VolumeFlow](symbol.sym, value)
    }

  implicit val opVolumeFlowConv: EKey[Option[VolumeFlow]] =
    new EKey[Option[VolumeFlow]] {
      def as(symbol: Symbol, value: Option[VolumeFlow]): 
          EProperty[Option[VolumeFlow]] =
        EProperty[Option[VolumeFlow]](symbol, value)
      def as(symbol: EKeyType[Option[VolumeFlow]], value: Option[VolumeFlow]): 
          EProperty[Option[VolumeFlow]] = 
        EProperty[Option[VolumeFlow]](symbol.sym, value)
    }

  implicit val yankConv: EKey[Yank] =
    new EKey[Yank] {
      def as(symbol: Symbol, value: Yank): EProperty[Yank] = 
        EProperty[Yank](symbol, value)
      def as(symbol: EKeyType[Yank], value: Yank): 
          EProperty[Yank] = 
        EProperty[Yank](symbol.sym, value)
    }

  implicit val opYankConv: EKey[Option[Yank]] =
    new EKey[Option[Yank]] {
      def as(symbol: Symbol, value: Option[Yank]): 
          EProperty[Option[Yank]] =
        EProperty[Option[Yank]](symbol, value)
      def as(symbol: EKeyType[Option[Yank]], value: Option[Yank]): 
          EProperty[Option[Yank]] = 
        EProperty[Option[Yank]](symbol.sym, value)
    }


  implicit val illuminanceConv: EKey[Illuminance] =
    new EKey[Illuminance] {
      def as(symbol: Symbol, value: Illuminance): EProperty[Illuminance] =
        EProperty[Illuminance](symbol, value)
      def as(symbol: EKeyType[Illuminance], value: Illuminance): 
          EProperty[Illuminance] = 
        EProperty[Illuminance](symbol.sym, value)
    }

  implicit val opIlluminanceConv: EKey[Option[Illuminance]] =
    new EKey[Option[Illuminance]] {
      def as(symbol: Symbol, value: Option[Illuminance]): 
          EProperty[Option[Illuminance]] =
        EProperty[Option[Illuminance]](symbol, value)
      def as(symbol: EKeyType[Option[Illuminance]], value: Option[Illuminance]):
          EProperty[Option[Illuminance]] = 
        EProperty[Option[Illuminance]](symbol.sym, value)
    }

  implicit val luminanceConv: EKey[Luminance] =
    new EKey[Luminance] {
      def as(symbol: Symbol, value: Luminance): EProperty[Luminance] =
        EProperty[Luminance](symbol, value)
      def as(symbol: EKeyType[Luminance], value: Luminance): 
          EProperty[Luminance] = 
        EProperty[Luminance](symbol.sym, value)
    }

  implicit val opLuminanceConv: EKey[Option[Luminance]] =
    new EKey[Option[Luminance]] {
      def as(symbol: Symbol, value: Option[Luminance]): 
          EProperty[Option[Luminance]] =
        EProperty[Option[Luminance]](symbol, value)
      def as(symbol: EKeyType[Option[Luminance]], value: Option[Luminance]): 
          EProperty[Option[Luminance]] = 
        EProperty[Option[Luminance]](symbol.sym, value)
    }

  implicit val luminousEnergyConv: EKey[LuminousEnergy] =
    new EKey[LuminousEnergy] {
      def as(symbol: Symbol, value: LuminousEnergy): EProperty[LuminousEnergy] =
        EProperty[LuminousEnergy](symbol, value)
      def as(symbol: EKeyType[LuminousEnergy], value: LuminousEnergy): 
          EProperty[LuminousEnergy] = 
        EProperty[LuminousEnergy](symbol.sym, value)
    }

  implicit val opLuminousEnergyConv: EKey[Option[LuminousEnergy]] =
    new EKey[Option[LuminousEnergy]] {
      def as(symbol: Symbol, value: Option[LuminousEnergy]): 
          EProperty[Option[LuminousEnergy]] =
        EProperty[Option[LuminousEnergy]](symbol, value)
      def as(
        symbol: EKeyType[Option[LuminousEnergy]], 
        value: Option[LuminousEnergy]):
          EProperty[Option[LuminousEnergy]] = 
        EProperty[Option[LuminousEnergy]](symbol.sym, value)
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

  implicit val opLuminousExposureConv: EKey[Option[LuminousExposure]] =
    new EKey[Option[LuminousExposure]] {
      def as(symbol: Symbol, value: Option[LuminousExposure]): 
          EProperty[Option[LuminousExposure]] =
        EProperty[Option[LuminousExposure]](symbol, value)
      def as(
        symbol: EKeyType[Option[LuminousExposure]], 
        value: Option[LuminousExposure]):
          EProperty[Option[LuminousExposure]] = 
        EProperty[Option[LuminousExposure]](symbol.sym, value)
    }

  implicit val luminousFluxConv: EKey[LuminousFlux] =
    new EKey[LuminousFlux] {
      def as(symbol: Symbol, value: LuminousFlux): EProperty[LuminousFlux] =
        EProperty[LuminousFlux](symbol, value)
      def as(symbol: EKeyType[LuminousFlux], value: LuminousFlux): 
          EProperty[LuminousFlux] = 
        EProperty[LuminousFlux](symbol.sym, value)
    }

  implicit val opLuminousFluxConv: EKey[Option[LuminousFlux]] =
    new EKey[Option[LuminousFlux]] {
      def as(symbol: Symbol, value: Option[LuminousFlux]): 
          EProperty[Option[LuminousFlux]] =
        EProperty[Option[LuminousFlux]](symbol, value)
      def as(
        symbol: EKeyType[Option[LuminousFlux]], value: Option[LuminousFlux]):
          EProperty[Option[LuminousFlux]] = 
        EProperty[Option[LuminousFlux]](symbol.sym, value)
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

  implicit val opLuminousIntensityConv: EKey[Option[LuminousIntensity]] =
    new EKey[Option[LuminousIntensity]] {
      def as(symbol: Symbol, value: Option[LuminousIntensity]): 
          EProperty[Option[LuminousIntensity]] =
        EProperty[Option[LuminousIntensity]](symbol, value)
      def as(
        symbol: EKeyType[Option[LuminousIntensity]], 
        value: Option[LuminousIntensity]):
          EProperty[Option[LuminousIntensity]] = 
        EProperty[Option[LuminousIntensity]](symbol.sym, value)
    }


  implicit val irradianceConv: EKey[Irradiance] =
    new EKey[Irradiance] {
      def as(symbol: Symbol, value: Irradiance): EProperty[Irradiance] = 
        EProperty[Irradiance](symbol, value)
      def as(symbol: EKeyType[Irradiance], value: Irradiance): 
          EProperty[Irradiance] = 
        EProperty[Irradiance](symbol.sym, value)
    }

  implicit val opIrradianceConv: EKey[Option[Irradiance]] =
    new EKey[Option[Irradiance]] {
      def as(symbol: Symbol, value: Option[Irradiance]): 
          EProperty[Option[Irradiance]] =
        EProperty[Option[Irradiance]](symbol, value)
      def as(symbol: EKeyType[Option[Irradiance]], value: Option[Irradiance]): 
          EProperty[Option[Irradiance]] = 
        EProperty[Option[Irradiance]](symbol.sym, value)
    }

  implicit val radianceConv: EKey[Radiance] =
    new EKey[Radiance] {
      def as(symbol: Symbol, value: Radiance): EProperty[Radiance] = 
        EProperty[Radiance](symbol, value)
      def as(symbol: EKeyType[Radiance], value: Radiance): 
          EProperty[Radiance] = 
        EProperty[Radiance](symbol.sym, value)
    }

  implicit val opRadianceConv: EKey[Option[Radiance]] =
    new EKey[Option[Radiance]] {
      def as(symbol: Symbol, value: Option[Radiance]): 
          EProperty[Option[Radiance]] =
        EProperty[Option[Radiance]](symbol, value)
      def as(symbol: EKeyType[Option[Radiance]], value: Option[Radiance]): 
          EProperty[Option[Radiance]] = 
        EProperty[Option[Radiance]](symbol.sym, value)
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

  implicit val opSpectralIntensityConv: EKey[Option[SpectralIntensity]] =
    new EKey[Option[SpectralIntensity]] {
      def as(symbol: Symbol, value: Option[SpectralIntensity]): 
          EProperty[Option[SpectralIntensity]] =
        EProperty[Option[SpectralIntensity]](symbol, value)
      def as(
        symbol: EKeyType[Option[SpectralIntensity]], 
        value: Option[SpectralIntensity]):
          EProperty[Option[SpectralIntensity]] = 
        EProperty[Option[SpectralIntensity]](symbol.sym, value)
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

  implicit val opSpectralIrradianceConv: EKey[Option[SpectralIrradiance]] =
    new EKey[Option[SpectralIrradiance]] {
      def as(symbol: Symbol, value: Option[SpectralIrradiance]): 
          EProperty[Option[SpectralIrradiance]] =
        EProperty[Option[SpectralIrradiance]](symbol, value)
      def as(
        symbol: EKeyType[Option[SpectralIrradiance]], 
        value: Option[SpectralIrradiance]):
          EProperty[Option[SpectralIrradiance]] = 
        EProperty[Option[SpectralIrradiance]](symbol.sym, value)
    }

  implicit val spectralPowerConv: EKey[SpectralPower] =
    new EKey[SpectralPower] {
      def as(symbol: Symbol, value: SpectralPower): EProperty[SpectralPower] = 
        EProperty[SpectralPower](symbol, value)
      def as(symbol: EKeyType[SpectralPower], value: SpectralPower): 
          EProperty[SpectralPower] = 
        EProperty[SpectralPower](symbol.sym, value)
    }

  implicit val opSpectralPowerConv: EKey[Option[SpectralPower]] =
    new EKey[Option[SpectralPower]] {
      def as(symbol: Symbol, value: Option[SpectralPower]): 
          EProperty[Option[SpectralPower]] =
        EProperty[Option[SpectralPower]](symbol, value)
      def as(
        symbol: EKeyType[Option[SpectralPower]], value: Option[SpectralPower]):
          EProperty[Option[SpectralPower]] = 
        EProperty[Option[SpectralPower]](symbol.sym, value)
    }


  implicit val angleConv: EKey[Angle] =
    new EKey[Angle] {
      def as(symbol: Symbol, value: Angle): EProperty[Angle] =
        EProperty[Angle](symbol, value)
      def as(symbol: EKeyType[Angle], value: Angle): 
          EProperty[Angle] = 
        EProperty[Angle](symbol.sym, value)
    }

  implicit val opAngleConv: EKey[Option[Angle]] =
    new EKey[Option[Angle]] {
      def as(symbol: Symbol, value: Option[Angle]): 
          EProperty[Option[Angle]] =
        EProperty[Option[Angle]](symbol, value)
      def as(symbol: EKeyType[Option[Angle]], value: Option[Angle]): 
          EProperty[Option[Angle]] = 
        EProperty[Option[Angle]](symbol.sym, value)
    }

  implicit val lengthConv: EKey[Length] =
    new EKey[Length] {
      def as(symbol: Symbol, value: Length): EProperty[Length] = 
        EProperty[Length](symbol, value)
      def as(symbol: EKeyType[Length], value: Length): 
          EProperty[Length] = 
        EProperty[Length](symbol.sym, value)
    }

  implicit val opLengthConv: EKey[Option[Length]] =
    new EKey[Option[Length]] {
      def as(symbol: Symbol, value: Option[Length]): 
          EProperty[Option[Length]] =
        EProperty[Option[Length]](symbol, value)
      def as(symbol: EKeyType[Option[Length]], value: Option[Length]): 
          EProperty[Option[Length]] = 
        EProperty[Option[Length]](symbol.sym, value)
    }

  implicit val areaConv: EKey[Area] =
    new EKey[Area] {
      def as(symbol: Symbol, value: Area): EProperty[Area] = 
        EProperty[Area](symbol, value)
      def as(symbol: EKeyType[Area], value: Area): 
          EProperty[Area] = 
        EProperty[Area](symbol.sym, value)
    }

  implicit val opAreaConv: EKey[Option[Area]] =
    new EKey[Option[Area]] {
      def as(symbol: Symbol, value: Option[Area]): 
          EProperty[Option[Area]] =
        EProperty[Option[Area]](symbol, value)
      def as(symbol: EKeyType[Option[Area]], value: Option[Area]): 
          EProperty[Option[Area]] = 
        EProperty[Option[Area]](symbol.sym, value)
    }

  implicit val volumeConv: EKey[Volume] =
    new EKey[Volume] {
      def as(symbol: Symbol, value: Volume): EProperty[Volume] = 
        EProperty[Volume](symbol, value)
      def as(symbol: EKeyType[Volume], value: Volume): 
          EProperty[Volume] = 
        EProperty[Volume](symbol.sym, value)
    }

  implicit val opVolumeConv: EKey[Option[Volume]] =
    new EKey[Option[Volume]] {
      def as(symbol: Symbol, value: Option[Volume]): 
          EProperty[Option[Volume]] =
        EProperty[Option[Volume]](symbol, value)
      def as(symbol: EKeyType[Option[Volume]], value: Option[Volume]): 
          EProperty[Option[Volume]] = 
        EProperty[Option[Volume]](symbol.sym, value)
    }

  implicit val solidAngleConv: EKey[SolidAngle] =
    new EKey[SolidAngle] {
      def as(symbol: Symbol, value: SolidAngle): EProperty[SolidAngle] =
        EProperty[SolidAngle](symbol, value)
      def as(symbol: EKeyType[SolidAngle], value: SolidAngle): 
          EProperty[SolidAngle] = 
        EProperty[SolidAngle](symbol.sym, value)
    }

  implicit val opSolidAngleConv: EKey[Option[SolidAngle]] =
    new EKey[Option[SolidAngle]] {
      def as(symbol: Symbol, value: Option[SolidAngle]): 
          EProperty[Option[SolidAngle]] =
        EProperty[Option[SolidAngle]](symbol, value)
      def as(symbol: EKeyType[Option[SolidAngle]], value: Option[SolidAngle]): 
          EProperty[Option[SolidAngle]] = 
        EProperty[Option[SolidAngle]](symbol.sym, value)
    }


  implicit val tempConv: EKey[Temperature] =
    new EKey[Temperature] {
      def as(symbol: Symbol, value: Temperature): EProperty[Temperature] =
        EProperty[Temperature](symbol, value)
      def as(symbol: EKeyType[Temperature], value: Temperature): 
          EProperty[Temperature] =
        EProperty[Temperature](symbol.sym, value)
    }

  implicit val opTempConv: EKey[Option[Temperature]] =
    new EKey[Option[Temperature]] {
      def as(symbol: Symbol, value: Option[Temperature]): 
          EProperty[Option[Temperature]] =
        EProperty[Option[Temperature]](symbol, value)
      def as(
        symbol: EKeyType[Option[Temperature]], value: Option[Temperature]):
          EProperty[Option[Temperature]] = 
        EProperty[Option[Temperature]](symbol.sym, value)
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

  implicit val opThermalCapacityConv: EKey[Option[ThermalCapacity]] =
    new EKey[Option[ThermalCapacity]] {
      def as(symbol: Symbol, value: Option[ThermalCapacity]): 
          EProperty[Option[ThermalCapacity]] =
        EProperty[Option[ThermalCapacity]](symbol, value)
      def as(
        symbol: EKeyType[Option[ThermalCapacity]], 
        value: Option[ThermalCapacity]):
          EProperty[Option[ThermalCapacity]] = 
        EProperty[Option[ThermalCapacity]](symbol.sym, value)
    }


  implicit val timeConv: EKey[Time] =
    new EKey[Time] {
      def as(symbol: Symbol, value: Time): EProperty[Time] = 
        EProperty[Time](symbol, value)
      def as(symbol: EKeyType[Time], value: Time): 
          EProperty[Time] = 
        EProperty[Time](symbol.sym, value)
    }

  implicit val opTimeConv: EKey[Option[Time]] =
    new EKey[Option[Time]] {
      def as(symbol: Symbol, value: Option[Time]): 
          EProperty[Option[Time]] =
        EProperty[Option[Time]](symbol, value)
      def as(symbol: EKeyType[Option[Time]], value: Option[Time]): 
          EProperty[Option[Time]] = 
        EProperty[Option[Time]](symbol.sym, value)
    }

  implicit val frequencyConv: EKey[Frequency] =
    new EKey[Frequency] {
      def as(symbol: Symbol, value: Frequency): EProperty[Frequency] =
        EProperty[Frequency](symbol, value)
      def as(symbol: EKeyType[Frequency], value: Frequency): 
          EProperty[Frequency] = 
        EProperty[Frequency](symbol.sym, value)
    }

  implicit val opFrequencyConv: EKey[Option[Frequency]] =
    new EKey[Option[Frequency]] {
      def as(symbol: Symbol, value: Option[Frequency]): 
          EProperty[Option[Frequency]] =
        EProperty[Option[Frequency]](symbol, value)
      def as(symbol: EKeyType[Option[Frequency]], value: Option[Frequency]): 
          EProperty[Option[Frequency]] = 
        EProperty[Option[Frequency]](symbol.sym, value)
    }

  implicit val timeSquaredConv: EKey[TimeSquared] =
    new EKey[TimeSquared] {
      def as(symbol: Symbol, value: TimeSquared): EProperty[TimeSquared] =
        EProperty[TimeSquared](symbol, value)
      def as(symbol: EKeyType[TimeSquared], value: TimeSquared): 
          EProperty[TimeSquared] = 
        EProperty[TimeSquared](symbol.sym, value)
    }

  implicit val opTimeSquaredConv: EKey[Option[TimeSquared]] =
    new EKey[Option[TimeSquared]] {
      def as(symbol: Symbol, value: Option[TimeSquared]): 
          EProperty[Option[TimeSquared]] =
        EProperty[Option[TimeSquared]](symbol, value)
      def as(symbol: EKeyType[Option[TimeSquared]], value: Option[TimeSquared]):
          EProperty[Option[TimeSquared]] = 
        EProperty[Option[TimeSquared]](symbol.sym, value)
    }

  /**
    * trait to extend if you want to use extensible EKeys in a specific class
    */
  object SquantsExtensible extends HasConv {

    def conv(builder: HMapBuilder, t: Any): Boolean =
      t match {
        case EProperty(k, v) => v match {
          case m: Dimensionless =>
            builder.add[Dimensionless](
              new EKeyType[Dimensionless](k), 
              t.asInstanceOf[EProperty[Dimensionless]])
            true
          case Some(m: Dimensionless) =>
            builder.add[Option[Dimensionless]](
              new EKeyType[Option[Dimensionless]](k), 
              t.asInstanceOf[EProperty[Option[Dimensionless]]])
            true

          case m: ElectricCurrent =>
            builder.add[ElectricCurrent](
              new EKeyType[ElectricCurrent](k), 
              t.asInstanceOf[EProperty[ElectricCurrent]])
            true
          case Some(m: ElectricCurrent) =>
            builder.add[Option[ElectricCurrent]](
              new EKeyType[Option[ElectricCurrent]](k), 
              t.asInstanceOf[EProperty[Option[ElectricCurrent]]])
            true
          case m: Capacitance =>
            builder.add[Capacitance](
              new EKeyType[Capacitance](k), 
              t.asInstanceOf[EProperty[Capacitance]])
            true
          case Some(m: Capacitance) =>
            builder.add[Option[Capacitance]](
              new EKeyType[Option[Capacitance]](k), 
              t.asInstanceOf[EProperty[Option[Capacitance]]])
            true
          case m: Conductivity =>
            builder.add[Conductivity](
              new EKeyType[Conductivity](k), 
              t.asInstanceOf[EProperty[Conductivity]])
            true
          case Some(m: Conductivity) =>
            builder.add[Option[Conductivity]](
              new EKeyType[Option[Conductivity]](k), 
              t.asInstanceOf[EProperty[Option[Conductivity]]])
            true
          case m: ElectricCharge =>
            builder.add[ElectricCharge](
              new EKeyType[ElectricCharge](k), 
              t.asInstanceOf[EProperty[ElectricCharge]])
            true
          case Some(m: ElectricCharge) =>
            builder.add[Option[ElectricCharge]](
              new EKeyType[Option[ElectricCharge]](k), 
              t.asInstanceOf[EProperty[Option[ElectricCharge]]])
            true
          case m: ElectricPotential =>
            builder.add[ElectricPotential](
              new EKeyType[ElectricPotential](k), 
              t.asInstanceOf[EProperty[ElectricPotential]])
            true
          case Some(m: ElectricPotential) =>
            builder.add[Option[ElectricPotential]](
              new EKeyType[Option[ElectricPotential]](k), 
              t.asInstanceOf[EProperty[Option[ElectricPotential]]])
            true
          case m: ElectricalConductance =>
            builder.add[ElectricalConductance](
              new EKeyType[ElectricalConductance](k), 
              t.asInstanceOf[EProperty[ElectricalConductance]])
            true
          case Some(m: ElectricalConductance) =>
            builder.add[Option[ElectricalConductance]](
              new EKeyType[Option[ElectricalConductance]](k), 
              t.asInstanceOf[EProperty[Option[ElectricalConductance]]])
            true
          case m: ElectricalResistance =>
            builder.add[ElectricalResistance](
              new EKeyType[ElectricalResistance](k), 
              t.asInstanceOf[EProperty[ElectricalResistance]])
            true
          case Some(m: ElectricalResistance) =>
            builder.add[Option[ElectricalResistance]](
              new EKeyType[Option[ElectricalResistance]](k), 
              t.asInstanceOf[EProperty[Option[ElectricalResistance]]])
            true
          case m: Inductance =>
            builder.add[Inductance](
              new EKeyType[Inductance](k), 
              t.asInstanceOf[EProperty[Inductance]])
            true
          case Some(m: Inductance) =>
            builder.add[Option[Inductance]](
              new EKeyType[Option[Inductance]](k), 
              t.asInstanceOf[EProperty[Option[Inductance]]])
            true
          case m: MagneticFlux =>
            builder.add[MagneticFlux](
              new EKeyType[MagneticFlux](k), 
              t.asInstanceOf[EProperty[MagneticFlux]])
            true
          case Some(m: MagneticFlux) =>
            builder.add[Option[MagneticFlux]](
              new EKeyType[Option[MagneticFlux]](k), 
              t.asInstanceOf[EProperty[Option[MagneticFlux]]])
            true
          case m: MagneticFluxDensity =>
            builder.add[MagneticFluxDensity](
              new EKeyType[MagneticFluxDensity](k), 
              t.asInstanceOf[EProperty[MagneticFluxDensity]])
            true
          case Some(m: MagneticFluxDensity) =>
            builder.add[Option[MagneticFluxDensity]](
              new EKeyType[Option[MagneticFluxDensity]](k), 
              t.asInstanceOf[EProperty[Option[MagneticFluxDensity]]])
            true
          case m: Resistivity =>
            builder.add[Resistivity](
              new EKeyType[Resistivity](k), 
              t.asInstanceOf[EProperty[Resistivity]])
            true
          case Some(m: Resistivity) =>
            builder.add[Option[Resistivity]](
              new EKeyType[Option[Resistivity]](k), 
              t.asInstanceOf[EProperty[Option[Resistivity]]])
            true

          case e: Energy =>
            builder.add[Energy](
              new EKeyType[Energy](k), t.asInstanceOf[EProperty[Energy]])
            true
          case Some(e: Energy) =>
            builder.add[Option[Energy]](
              new EKeyType[Option[Energy]](k), 
              t.asInstanceOf[EProperty[Option[Energy]]])
            true
          case m: PowerDensity =>
            builder.add[PowerDensity](
              new EKeyType[PowerDensity](k), 
              t.asInstanceOf[EProperty[PowerDensity]])
            true
          case Some(m: PowerDensity) =>
            builder.add[Option[PowerDensity]](
              new EKeyType[Option[PowerDensity]](k), 
              t.asInstanceOf[EProperty[Option[PowerDensity]]])
            true
          case m: EnergyDensity =>
            builder.add[EnergyDensity](
              new EKeyType[EnergyDensity](k), 
              t.asInstanceOf[EProperty[EnergyDensity]])
            true
          case Some(m: EnergyDensity) =>
            builder.add[Option[EnergyDensity]](
              new EKeyType[Option[EnergyDensity]](k), 
              t.asInstanceOf[EProperty[Option[EnergyDensity]]])
            true
          case m: Power =>
            builder.add[Power](
              new EKeyType[Power](k), t.asInstanceOf[EProperty[Power]])
            true
          case Some(m: Power) =>
            builder.add[Option[Power]](
              new EKeyType[Option[Power]](k), 
              t.asInstanceOf[EProperty[Option[Power]]])
            true
          case m: PowerRamp =>
            builder.add[PowerRamp](
              new EKeyType[PowerRamp](k), 
              t.asInstanceOf[EProperty[PowerRamp]])
            true
          case Some(m: PowerRamp) =>
            builder.add[Option[PowerRamp]](
              new EKeyType[Option[PowerRamp]](k), 
              t.asInstanceOf[EProperty[Option[PowerRamp]]])
            true
          case m: SpecificEnergy =>
            builder.add[SpecificEnergy](
              new EKeyType[SpecificEnergy](k), 
              t.asInstanceOf[EProperty[SpecificEnergy]])
            true
          case Some(m: SpecificEnergy) =>
            builder.add[Option[SpecificEnergy]](
              new EKeyType[Option[SpecificEnergy]](k), 
              t.asInstanceOf[EProperty[Option[SpecificEnergy]]])
            true

          case m: Money =>
            builder.add[Money](
              new EKeyType[Money](k), t.asInstanceOf[EProperty[Money]])
            true
          case Some(m: Money) =>
            builder.add[Option[Money]](
              new EKeyType[Option[Money]](k), 
              t.asInstanceOf[EProperty[Option[Money]]])
            true

          case m: AreaDensity =>
            builder.add[AreaDensity](
              new EKeyType[AreaDensity](k), 
              t.asInstanceOf[EProperty[AreaDensity]])
            true
          case Some(m: AreaDensity) =>
            builder.add[Option[AreaDensity]](
              new EKeyType[Option[AreaDensity]](k), 
              t.asInstanceOf[EProperty[Option[AreaDensity]]])
            true
          case d: Density =>
            builder.add[Density](
              new EKeyType[Density](k), t.asInstanceOf[EProperty[Density]])
            true
          case Some(d: Density) =>
            builder.add[Option[Density]](
              new EKeyType[Option[Density]](k), 
              t.asInstanceOf[EProperty[Option[Density]]])
            true
          case m: Mass =>
            builder.add[Mass](
              new EKeyType[Mass](k), t.asInstanceOf[EProperty[Mass]])
            true
          case Some(m: Mass) =>
            builder.add[Option[Mass]](
              new EKeyType[Option[Mass]](k), 
              t.asInstanceOf[EProperty[Option[Mass]]])
            true
          case m: ChemicalAmount =>
            builder.add[ChemicalAmount](
              new EKeyType[ChemicalAmount](k), 
              t.asInstanceOf[EProperty[ChemicalAmount]])
            true
          case Some(m: ChemicalAmount) =>
            builder.add[Option[ChemicalAmount]](
              new EKeyType[Option[ChemicalAmount]](k), 
              t.asInstanceOf[EProperty[Option[ChemicalAmount]]])
            true

          case m: Acceleration =>
            builder.add[Acceleration](
              new EKeyType[Acceleration](k), 
              t.asInstanceOf[EProperty[Acceleration]])
            true
          case Some(m: Acceleration) =>
            builder.add[Option[Acceleration]](
              new EKeyType[Option[Acceleration]](k), 
              t.asInstanceOf[EProperty[Option[Acceleration]]])
            true
          case m: AngularVelocity =>
            builder.add[AngularVelocity](
              new EKeyType[AngularVelocity](k), 
              t.asInstanceOf[EProperty[AngularVelocity]])
            true
          case Some(m: AngularVelocity) =>
            builder.add[Option[AngularVelocity]](
              new EKeyType[Option[AngularVelocity]](k), 
              t.asInstanceOf[EProperty[Option[AngularVelocity]]])
            true
          case m: Force =>
            builder.add[Force](
              new EKeyType[Force](k), t.asInstanceOf[EProperty[Force]])
            true
          case Some(m: Force) =>
            builder.add[Option[Force]](
              new EKeyType[Option[Force]](k), 
              t.asInstanceOf[EProperty[Option[Force]]])
            true
          case m: Jerk =>
            builder.add[Jerk](
              new EKeyType[Jerk](k), t.asInstanceOf[EProperty[Jerk]])
            true
          case Some(m: Jerk) =>
            builder.add[Option[Jerk]](
              new EKeyType[Option[Jerk]](k), 
              t.asInstanceOf[EProperty[Option[Jerk]]])
            true
          case m: MassFlow =>
            builder.add[MassFlow](
              new EKeyType[MassFlow](k), t.asInstanceOf[EProperty[MassFlow]])
            true
          case Some(m: MassFlow) =>
            builder.add[Option[MassFlow]](
              new EKeyType[Option[MassFlow]](k), 
              t.asInstanceOf[EProperty[Option[MassFlow]]])
            true
          case m: Momentum =>
            builder.add[Momentum](
              new EKeyType[Momentum](k), t.asInstanceOf[EProperty[Momentum]])
            true
          case Some(m: Momentum) =>
            builder.add[Option[Momentum]](
              new EKeyType[Option[Momentum]](k), 
              t.asInstanceOf[EProperty[Option[Momentum]]])
            true
          case m: Pressure =>
            builder.add[Pressure](
              new EKeyType[Pressure](k), t.asInstanceOf[EProperty[Pressure]])
            true
          case Some(m: Pressure) =>
            builder.add[Option[Pressure]](
              new EKeyType[Option[Pressure]](k), 
              t.asInstanceOf[EProperty[Option[Pressure]]])
            true
          case m: PressureChange =>
            builder.add[PressureChange](
              new EKeyType[PressureChange](k), 
              t.asInstanceOf[EProperty[PressureChange]])
            true
          case Some(m: PressureChange) =>
            builder.add[Option[PressureChange]](
              new EKeyType[Option[PressureChange]](k), 
              t.asInstanceOf[EProperty[Option[PressureChange]]])
            true
          case m: Velocity =>
            builder.add[Velocity](
              new EKeyType[Velocity](k), t.asInstanceOf[EProperty[Velocity]])
            true
          case Some(m: Velocity) =>
            builder.add[Option[Velocity]](
              new EKeyType[Option[Velocity]](k), 
              t.asInstanceOf[EProperty[Option[Velocity]]])
            true
          case m: VolumeFlow =>
            builder.add[VolumeFlow](
              new EKeyType[VolumeFlow](k), 
              t.asInstanceOf[EProperty[VolumeFlow]])
            true
          case Some(m: VolumeFlow) =>
            builder.add[Option[VolumeFlow]](
              new EKeyType[Option[VolumeFlow]](k), 
              t.asInstanceOf[EProperty[Option[VolumeFlow]]])
            true
          case m: Yank =>
            builder.add[Yank](
              new EKeyType[Yank](k), t.asInstanceOf[EProperty[Yank]])
            true
          case Some(m: Yank) =>
            builder.add[Option[Yank]](
              new EKeyType[Option[Yank]](k), 
              t.asInstanceOf[EProperty[Option[Yank]]])
            true

          case m: Illuminance =>
            builder.add[Illuminance](
              new EKeyType[Illuminance](k), 
              t.asInstanceOf[EProperty[Illuminance]])
            true
          case Some(m: Illuminance) =>
            builder.add[Option[Illuminance]](
              new EKeyType[Option[Illuminance]](k), 
              t.asInstanceOf[EProperty[Option[Illuminance]]])
            true
          case m: Luminance =>
            builder.add[Luminance](
              new EKeyType[Luminance](k), t.asInstanceOf[EProperty[Luminance]])
            true
          case Some(m: Luminance) =>
            builder.add[Option[Luminance]](
              new EKeyType[Option[Luminance]](k), 
              t.asInstanceOf[EProperty[Option[Luminance]]])
            true
          case m: LuminousEnergy =>
            builder.add[LuminousEnergy](
              new EKeyType[LuminousEnergy](k), 
              t.asInstanceOf[EProperty[LuminousEnergy]])
            true
          case Some(m: LuminousEnergy) =>
            builder.add[Option[LuminousEnergy]](
              new EKeyType[Option[LuminousEnergy]](k), 
              t.asInstanceOf[EProperty[Option[LuminousEnergy]]])
            true
          case m: LuminousExposure =>
            builder.add[LuminousExposure](
              new EKeyType[LuminousExposure](k), 
              t.asInstanceOf[EProperty[LuminousExposure]])
            true
          case Some(m: LuminousExposure) =>
            builder.add[Option[LuminousExposure]](
              new EKeyType[Option[LuminousExposure]](k), 
              t.asInstanceOf[EProperty[Option[LuminousExposure]]])
            true
          case m: LuminousFlux =>
            builder.add[LuminousFlux](
              new EKeyType[LuminousFlux](k), 
              t.asInstanceOf[EProperty[LuminousFlux]])
            true
          case Some(m: LuminousFlux) =>
            builder.add[Option[LuminousFlux]](
              new EKeyType[Option[LuminousFlux]](k), 
              t.asInstanceOf[EProperty[Option[LuminousFlux]]])
            true
          case m: LuminousIntensity =>
            builder.add[LuminousFlux](
              new EKeyType[LuminousFlux](k), 
              t.asInstanceOf[EProperty[LuminousFlux]])
            true
          case Some(m: LuminousIntensity) =>
            builder.add[Option[LuminousFlux]](
              new EKeyType[Option[LuminousFlux]](k), 
              t.asInstanceOf[EProperty[Option[LuminousFlux]]])
            true

          case m: Irradiance =>
            builder.add[Irradiance](
              new EKeyType[Irradiance](k), 
              t.asInstanceOf[EProperty[Irradiance]])
            true
          case Some(m: Irradiance) =>
            builder.add[Option[Irradiance]](
              new EKeyType[Option[Irradiance]](k), 
              t.asInstanceOf[EProperty[Option[Irradiance]]])
            true
          case m: Radiance =>
            builder.add[Radiance](
              new EKeyType[Radiance](k), t.asInstanceOf[EProperty[Radiance]])
            true
          case Some(m: Radiance) =>
            builder.add[Option[Radiance]](
              new EKeyType[Option[Radiance]](k), 
              t.asInstanceOf[EProperty[Option[Radiance]]])
            true
          case m: SpectralIntensity =>
            builder.add[SpectralIntensity](
              new EKeyType[SpectralIntensity](k), 
              t.asInstanceOf[EProperty[SpectralIntensity]])
            true
          case Some(m: SpectralIntensity) =>
            builder.add[Option[SpectralIntensity]](
              new EKeyType[Option[SpectralIntensity]](k), 
              t.asInstanceOf[EProperty[Option[SpectralIntensity]]])
            true
          case m: SpectralIrradiance =>
            builder.add[SpectralIrradiance](
              new EKeyType[SpectralIrradiance](k), 
              t.asInstanceOf[EProperty[SpectralIrradiance]])
            true
          case Some(m: SpectralIrradiance) =>
            builder.add[Option[SpectralIrradiance]](
              new EKeyType[Option[SpectralIrradiance]](k), 
              t.asInstanceOf[EProperty[Option[SpectralIrradiance]]])
            true
          case m: SpectralPower =>
            builder.add[SpectralPower](
              new EKeyType[SpectralPower](k), 
              t.asInstanceOf[EProperty[SpectralPower]])
            true
          case Some(m: SpectralPower) =>
            builder.add[Option[SpectralPower]](
              new EKeyType[Option[SpectralPower]](k), 
              t.asInstanceOf[EProperty[Option[SpectralPower]]])
            true

          case m: Angle =>
            builder.add[Angle](
              new EKeyType[Angle](k), t.asInstanceOf[EProperty[Angle]])
            true
          case Some(m: Angle) =>
            builder.add[Option[Angle]](
              new EKeyType[Option[Angle]](k), 
              t.asInstanceOf[EProperty[Option[Angle]]])
            true
          case m: Length =>
            builder.add[Length](
              new EKeyType[Length](k), t.asInstanceOf[EProperty[Length]])
            true
          case Some(m: Length) =>
            builder.add[Option[Length]](
              new EKeyType[Option[Length]](k), 
              t.asInstanceOf[EProperty[Option[Length]]])
            true
          case m: Area =>
            builder.add[Area](
              new EKeyType[Area](k), t.asInstanceOf[EProperty[Area]])
            true
          case Some(m: Area) =>
            builder.add[Option[Area]](
              new EKeyType[Option[Area]](k), 
              t.asInstanceOf[EProperty[Option[Area]]])
            true
          case m: Volume =>
            builder.add[Volume](
              new EKeyType[Volume](k), t.asInstanceOf[EProperty[Volume]])
            true
          case Some(m: Volume) =>
            builder.add[Option[Volume]](
              new EKeyType[Option[Volume]](k), 
              t.asInstanceOf[EProperty[Option[Volume]]])
            true
          case m: SolidAngle =>
            builder.add[SolidAngle](
              new EKeyType[SolidAngle](k), 
              t.asInstanceOf[EProperty[SolidAngle]])
            true
          case Some(m: SolidAngle) =>
            builder.add[Option[SolidAngle]](
              new EKeyType[Option[SolidAngle]](k), 
              t.asInstanceOf[EProperty[Option[SolidAngle]]])
            true

          case te: Temperature =>
            builder.add[Temperature](
              new EKeyType[Temperature](k), 
              t.asInstanceOf[EProperty[Temperature]])
            true
          case Some(te: Temperature) =>
            builder.add[Option[Temperature]](
              new EKeyType[Option[Temperature]](k), 
              t.asInstanceOf[EProperty[Option[Temperature]]])
            true
          case m: ThermalCapacity =>
            builder.add[ThermalCapacity](
              new EKeyType[ThermalCapacity](k), 
              t.asInstanceOf[EProperty[ThermalCapacity]])
            true
          case Some(m: ThermalCapacity) =>
            builder.add[Option[ThermalCapacity]](
              new EKeyType[Option[ThermalCapacity]](k), 
              t.asInstanceOf[EProperty[Option[ThermalCapacity]]])
            true

          case e: Time =>
            builder.add[Time](
              new EKeyType[Time](k), t.asInstanceOf[EProperty[Time]])
            true
          case Some(e: Time) =>
            builder.add[Option[Time]](
              new EKeyType[Option[Time]](k), 
              t.asInstanceOf[EProperty[Option[Time]]])
            true
          case m: Frequency =>
            builder.add[Frequency](
              new EKeyType[Frequency](k), 
              t.asInstanceOf[EProperty[Frequency]])
            true
          case Some(m: Frequency) =>
            builder.add[Option[Frequency]](
              new EKeyType[Option[Frequency]](k), 
              t.asInstanceOf[EProperty[Option[Frequency]]])
            true
          case m: TimeSquared =>
            builder.add[TimeSquared](
              new EKeyType[TimeSquared](k), 
              t.asInstanceOf[EProperty[TimeSquared]])
            true
          case Some(m: TimeSquared) =>
            builder.add[Option[TimeSquared]](
              new EKeyType[Option[TimeSquared]](k), 
              t.asInstanceOf[EProperty[Option[TimeSquared]]])
            true
          case p => false
        }
        case _ => assert(false); false
      }
  }

  delegates += SquantsExtensible
}
