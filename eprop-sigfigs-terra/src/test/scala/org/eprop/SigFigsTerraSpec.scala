
package org.eprop

import org.scalatest.FlatSpec
import org.eprop.EKey._
import org.eprop.EKeySigFigsTerra._

import org.sigfigs._
import org.sigfigs.terra._
import electro._
import energy.{ WattsPerCubicMeter => EWattsPerCubicMeter, _ }
import information._
import market._
import mass._
import motion._
import photo._
import radio._
import space._
import thermal._
import time._

class SigFigsTerraSpec extends FlatSpec {

  object DimensionlessPType extends EKeyType[Dimensionless]('dimensionless)

  object ElectricCurrentPType 
      extends EKeyType[ElectricCurrent]('electricCurrent)
  object CapacitancePType extends EKeyType[Capacitance]('capacitance)
  object ConductivityPType extends EKeyType[Conductivity]('conductivity)
  object ElectricChargePType extends EKeyType[ElectricCharge]('electricCharge)
  object ElectricPotentialPType 
      extends EKeyType[ElectricPotential]('electricPotential)
  object ElectricalConductancePType 
      extends EKeyType[ElectricalConductance]('electricalConductance)
  object ElectricalResistancePType 
      extends EKeyType[ElectricalResistance]('electricalResistance)
  object InductancePType extends EKeyType[Inductance]('inductance)
  object MagneticFluxPType extends EKeyType[MagneticFlux]('magneticFlux)
  object MagneticFluxDensityPType 
      extends EKeyType[MagneticFluxDensity]('magneticFluxDensity)
  object ResistivityPType extends EKeyType[Resistivity]('resistivity)

  object EnergyPType extends EKeyType[Energy]('energy)
  object PowerDensityPType extends EKeyType[PowerDensity]('powerDensity)
  object EnergyDensityPType extends EKeyType[EnergyDensity]('energyDensity)
  object EnergyAreaDensityPType 
      extends EKeyType[EnergyAreaDensity]('energyAreaDensity)
  object PowerPType extends EKeyType[Power]('power)
  object PowerRampPType extends EKeyType[PowerRamp]('powerRamp)
  object SpecificEnergyPType extends EKeyType[SpecificEnergy]('specificEnergy)
  object MolarEnergyPType extends EKeyType[MolarEnergy]('molarEnergy)

  object DataRatePType extends EKeyType[DataRate]('dataRate)
  object InformationPType extends EKeyType[Information]('information)

  object MoneyPType extends EKeyType[Money]('money)
  object EmployeePType extends EKeyType[Employee]('employee)
  object LaborPType extends EKeyType[Labor]('labor)

  object AreaDensityPType extends EKeyType[AreaDensity]('areaDensity)
  object DensityPType extends EKeyType[Density]('density)
  object MassPType extends EKeyType[Mass]('mass)
  object ChemicalAmountPType extends EKeyType[ChemicalAmount]('chemicalAmount)
  object MolarMassPType extends EKeyType[MolarMass]('molarMass)
  object ConcentrationPType extends EKeyType[Concentration]('concentration)
  object CatalyticActivityPType 
      extends EKeyType[CatalyticActivity]('catalyticActivity)

  object AccelerationPType extends EKeyType[Acceleration]('acceleration)
  object AngularAccelerationPType 
      extends EKeyType[AngularAcceleration]('angularAcceleration)
  object AngularVelocityPType 
      extends EKeyType[AngularVelocity]('angularVelocity)
  object ForcePType extends EKeyType[Force]('force)
  object JerkPType extends EKeyType[Jerk]('jerk)
  object MassFlowPType extends EKeyType[MassFlow]('massFlow)
  object MomentumPType extends EKeyType[Momentum]('momentum)
  object PressureChangePType extends EKeyType[PressureChange]('pressureChange)
  object PressurePType extends EKeyType[Pressure]('pressure)
  object VelocityPType extends EKeyType[Velocity]('velocity)
  object VolumeFlowPType extends EKeyType[VolumeFlow]('volumeFlow)
  object YankPType extends EKeyType[Yank]('yank)
  object SurfaceTensionPType extends EKeyType[SurfaceTension]('surfaceTension)
  object ViscosityPType extends EKeyType[Viscosity]('viscosity)

  object IlluminancePType extends EKeyType[Illuminance]('illuminance)
  object LuminancePType extends EKeyType[Luminance]('luminance)
  object LuminousEnergyPType extends EKeyType[LuminousEnergy]('luminousEnergy)
  object LuminousExposurePType 
      extends EKeyType[LuminousExposure]('luminousExposure)
  object LuminousFluxPType extends EKeyType[LuminousFlux]('luminousFlux)
  object LuminousIntensityPType 
      extends EKeyType[LuminousIntensity]('luminousIntensity)

  object IrradiancePType extends EKeyType[Irradiance]('irradiance)
  object RadiancePType extends EKeyType[Radiance]('radiance)
  object SpectralIntensityPType 
      extends EKeyType[SpectralIntensity]('spectralIntensity)
  object SpectralIrradiancePType 
      extends EKeyType[SpectralIrradiance]('spectralIrradiance)
  object SpectralPowerPType extends EKeyType[SpectralPower]('spectralPower)
  object ActivityPType extends EKeyType[Activity]('activity)
  object ParticleFluxPType extends EKeyType[ParticleFlux]('particleFlux)
  object DosePType extends EKeyType[Dose]('dose)
  object AreaTimePType extends EKeyType[AreaTime]('areaTime)
  object AbsorbedDosePType extends EKeyType[AbsorbedDose]('absorbedDose)

  object AnglePType extends EKeyType[Angle]('angle)
  object LengthPType extends EKeyType[Length]('length)
  object AreaPType extends EKeyType[Area]('area)
  object VolumePType extends EKeyType[Volume]('volume)
  object SolidAnglePType extends EKeyType[SolidAngle]('solidAngle)
  object SpecificVolumePType extends EKeyType[SpecificVolume]('specificVolume)
  object MolarVolumePType extends EKeyType[MolarVolume]('molarVolume)

  object TemperaturePType extends EKeyType[Temperature]('temperature)
  object ThermalCapacityPType 
      extends EKeyType[ThermalCapacity]('thermalCapacity)

  object TimePType extends EKeyType[Time]('time)
  object FrequencyPType extends EKeyType[Frequency]('frequency)
  object TimeSquaredPType extends EKeyType[TimeSquared]('timeSquared)

  "The properties" should "read squants types correctly" in {

    // declare your extensible model type
    class Container(props: EProperty[_]*) extends Extensible {

      merge(Seq(Kilograms(10) as MassPType)) // a default
      merge(props)

      def dimensionless: Option[Dimensionless] = 
        get[Dimensionless](DimensionlessPType)

      def electricCurrent: Option[ElectricCurrent] = 
        get[ElectricCurrent](ElectricCurrentPType)
      def capacitance: Option[Capacitance] = get[Capacitance](CapacitancePType)
      def conductivity: Option[Conductivity] = 
        get[Conductivity](ConductivityPType)
      def electricCharge: Option[ElectricCharge] = 
        get[ElectricCharge](ElectricChargePType)
      def electricPotential: Option[ElectricPotential] = 
        get[ElectricPotential](ElectricPotentialPType)
      def electricalConductance: Option[ElectricalConductance] = 
        get[ElectricalConductance](ElectricalConductancePType)
      def electricalResistance: Option[ElectricalResistance] = 
        get[ElectricalResistance](ElectricalResistancePType)
      def inductance: Option[Inductance] = get[Inductance](InductancePType)
      def magneticFlux: Option[MagneticFlux] = 
        get[MagneticFlux](MagneticFluxPType)
      def magneticFluxDensity: Option[MagneticFluxDensity] = 
        get[MagneticFluxDensity](MagneticFluxDensityPType)
      def resistivity: Option[Resistivity] = get[Resistivity](ResistivityPType)

      def energy: Option[Energy] = get[Energy](EnergyPType)
      def powerDensity: Option[PowerDensity] = 
        get[PowerDensity](PowerDensityPType)
      def energyDensity: Option[EnergyDensity] = 
        get[EnergyDensity](EnergyDensityPType)
      def energyAreaDensity: Option[EnergyAreaDensity] = 
        get[EnergyAreaDensity](EnergyAreaDensityPType)
      def power: Option[Power] = get[Power](PowerPType)
      def powerRamp: Option[PowerRamp] = get[PowerRamp](PowerRampPType)
      def specificEnergy: Option[SpecificEnergy] = 
        get[SpecificEnergy](SpecificEnergyPType)
      def molarEnergy: Option[MolarEnergy] = get[MolarEnergy](MolarEnergyPType)

      def dataRate: Option[DataRate] = get[DataRate](DataRatePType)
      def information: Option[Information] = get[Information](InformationPType)

      def money: Option[Money] = get[Money](MoneyPType)
      def employee: Option[Employee] = get[Employee](EmployeePType)
      def labor: Option[Labor] = get[Labor](LaborPType)

      def areaDensity: Option[AreaDensity] = get[AreaDensity](AreaDensityPType)
      def density: Option[Density] = get[Density](DensityPType)
      def mass: Option[Mass] = get[Mass](MassPType)
      def chemicalAmount: Option[ChemicalAmount] = 
        get[ChemicalAmount](ChemicalAmountPType)
      def molarMass: Option[MolarMass] = get[MolarMass](MolarMassPType)
      def concentration: Option[Concentration] = 
        get[Concentration](ConcentrationPType)
      def catalyticActivity: Option[CatalyticActivity] = 
        get[CatalyticActivity](CatalyticActivityPType)

      def acceleration: Option[Acceleration] = 
        get[Acceleration](AccelerationPType)
      def angularAcceleration: Option[AngularAcceleration] = 
        get[AngularAcceleration](AngularAccelerationPType)
      def angularVelocity: Option[AngularVelocity] = 
        get[AngularVelocity](AngularVelocityPType)
      def force: Option[Force] = get[Force](ForcePType)
      def jerk: Option[Jerk] = get[Jerk](JerkPType)
      def massFlow: Option[MassFlow] = get[MassFlow](MassFlowPType)
      def momentum: Option[Momentum] = get[Momentum](MomentumPType)
      def pressureChange: Option[PressureChange] = 
        get[PressureChange](PressureChangePType)
      def pressure: Option[Pressure] = get[Pressure](PressurePType)
      def velocity: Option[Velocity] = get[Velocity](VelocityPType)
      def volumeFlow: Option[VolumeFlow] = get[VolumeFlow](VolumeFlowPType)
      def yank: Option[Yank] = get[Yank](YankPType)
      def surfaceTension: Option[SurfaceTension] = 
        get[SurfaceTension](SurfaceTensionPType)
      def viscosity: Option[Viscosity] = get[Viscosity](ViscosityPType)

      def illuminance: Option[Illuminance] = get[Illuminance](IlluminancePType)
      def luminance: Option[Luminance] = get[Luminance](LuminancePType)
      def luminousEnergy: Option[LuminousEnergy] = 
        get[LuminousEnergy](LuminousEnergyPType)
      def luminousExposure: Option[LuminousExposure] = 
        get[LuminousExposure](LuminousExposurePType)
      def luminousFlux: Option[LuminousFlux] = 
        get[LuminousFlux](LuminousFluxPType)
      def luminousIntensity: Option[LuminousIntensity] = 
        get[LuminousIntensity](LuminousIntensityPType)

      def irradiance: Option[Irradiance] = get[Irradiance](IrradiancePType)
      def radiance: Option[Radiance] = get[Radiance](RadiancePType)
      def spectralIntensity: Option[SpectralIntensity] = 
        get[SpectralIntensity](SpectralIntensityPType)
      def spectralIrradiance: Option[SpectralIrradiance] = 
        get[SpectralIrradiance](SpectralIrradiancePType)
      def spectralPower: Option[SpectralPower] = 
        get[SpectralPower](SpectralPowerPType)
      def activity: Option[Activity] = get[Activity](ActivityPType)
      def particleFlux: Option[ParticleFlux] = 
        get[ParticleFlux](ParticleFluxPType)
      def dose: Option[Dose] = get[Dose](DosePType)
      def areaTime: Option[AreaTime] = get[AreaTime](AreaTimePType)
      def absorbedDose: Option[AbsorbedDose] = 
        get[AbsorbedDose](AbsorbedDosePType)

      def angle: Option[Angle] = get[Angle](AnglePType)
      def length: Option[Length] = get[Length](LengthPType)
      def area: Option[Area] = get[Area](AreaPType)
      def volume: Option[Volume] = get[Volume](VolumePType)
      def solidAngle: Option[SolidAngle] = get[SolidAngle](SolidAnglePType)
      def specificVolume: Option[SpecificVolume] = 
        get[SpecificVolume](SpecificVolumePType)
      def molarVolume: Option[MolarVolume] = get[MolarVolume](MolarVolumePType)

      def temperature: Option[Temperature] = get[Temperature](TemperaturePType)
      def thermalCapacity: Option[ThermalCapacity] = 
        get[ThermalCapacity](ThermalCapacityPType)

      def time: Option[Time] = get[Time](TimePType)
      def frequency: Option[Frequency] = get[Frequency](FrequencyPType)
      def timeSquared: Option[TimeSquared] = get[TimeSquared](TimeSquaredPType)
    }

    // now make an instance of your container with some values
    val container = new Container(
      Grams(10) as MassPType, Meters(10.0) as LengthPType, 
      SquareMeters(15.2) as AreaPType)
    assert(container.mass == Some(Kilograms(0.01)))
    assert(container.length == Some(Meters(10.0)))
    assert(container.area == Some(SquareMeters(15.2)))

    val container2 = new Container(
      Percent(50.0) as DimensionlessPType,

      Amperes(0.1) as ElectricCurrentPType,
      Farads(7) as CapacitancePType,
      SiemensPerMeter(6) as ConductivityPType,
      Coulombs(5) as ElectricChargePType,
      Volts(4) as ElectricPotentialPType,
      Siemens(3) as ElectricalConductancePType,
      Ohms(2000) as ElectricalResistancePType,
      Henry(15) as InductancePType,
      Webers(14) as MagneticFluxPType,
      Teslas(13) as MagneticFluxDensityPType,
      OhmMeters(12) as ResistivityPType,

      Joules(11) as EnergyPType,
      EWattsPerCubicMeter(10) as PowerDensityPType,
      JoulesPerCubicMeter(9) as EnergyDensityPType,
      JoulesPerSquareMeter(9) as EnergyAreaDensityPType,
      Watts(8) as PowerPType,
      WattsPerHour(7) as PowerRampPType,
      JoulesPerKilogram(6) as SpecificEnergyPType,
      JoulesPerMole(5) as MolarEnergyPType,

      BytesPerSecond(7000000) as DataRatePType,
      Bytes(100000) as InformationPType,

      USD(1000000) as MoneyPType,
      People(10) as EmployeePType,
      PersonHours(200000) as LaborPType,

      GramsPerSquareCentimeter(5) as AreaDensityPType,
      KilogramsPerCubicMeter(4) as DensityPType,
      Kilograms(3) as MassPType,
      Moles(2) as ChemicalAmountPType,
      KilogramsPerMole(71) as MolarMassPType,
      MolesPerCubicMeter(72) as ConcentrationPType,
      Katals(73) as CatalyticActivityPType,

      MetersPerSecondSquared(35) as AccelerationPType,
      DegreesPerSecondSquared(34) as AngularAccelerationPType,
      RadiansPerSecond(34) as AngularVelocityPType,
      Newtons(33) as ForcePType,
      MetersPerSecondCubed(32) as JerkPType,
      KilogramsPerSecond(31) as MassFlowPType,
      NewtonSeconds(30) as MomentumPType,
      PascalsPerSecond(29) as PressureChangePType,
      Bars(28) as PressurePType,
      KilometersPerHour(27) as VelocityPType,
      CubicMetersPerSecond(26) as VolumeFlowPType,
      NewtonsPerSecond(25) as YankPType,
      NewtonsPerMeter(25) as SurfaceTensionPType,
      PascalSeconds(25) as ViscosityPType,

      Lux(24) as IlluminancePType,
      CandelasPerSquareMeter(23) as LuminancePType,
      LumenSeconds(22) as LuminousEnergyPType,
      LuxSeconds(21) as LuminousExposurePType,
      Lumens(20) as LuminousFluxPType,
      Candelas(19) as LuminousIntensityPType,

      ErgsPerSecondPerSquareCentimeter(18) as IrradiancePType,
      WattsPerSteradianPerSquareMeter(17) as RadiancePType,
      WattsPerSteradianPerMeter(16) as SpectralIntensityPType,
      ErgsPerSecondPerSquareCentimeterPerAngstrom(9) as SpectralIrradiancePType,
      WattsPerMeter(15) as SpectralPowerPType,
      Becquerels(21) as ActivityPType,
      BecquerelsPerSquareMeterSecond(22) as ParticleFluxPType,
      Sieverts(23) as DosePType,
      SquareMeterSeconds(24) as AreaTimePType,
      Grays(25) as AbsorbedDosePType,

      Degrees(14) as AnglePType,
      Meters(13) as LengthPType,
      SquareMeters(12) as AreaPType,
      CubicMeters(11) as VolumePType,
      SquareRadians(10) as SolidAnglePType,
      CubicMetersPerKilogram(11) as SpecificVolumePType,
      CubicMetersPerMole(11) as MolarVolumePType,

      Kelvin(273.15) as TemperaturePType,
      JoulesPerKelvin(8) as ThermalCapacityPType,

      Seconds(7) as TimePType,
      Hertz(6) as FrequencyPType,
      SecondsSquared(SDD(5)) as TimeSquaredPType
    )

    assert(
      container2.dimensionless.get * container2.dimensionless.get == 
        Percent(SDD(25, 1)))

    assert(container2.electricCurrent.get == Milliamperes(100))
    assert(container2.capacitance.get == Farads(7))
    assert(container2.conductivity.get == SiemensPerMeter(6))
    assert(container2.electricCharge.get == Coulombs(5))
    assert(container2.electricPotential.get == Volts(4))
    assert(container2.electricalConductance.get == Siemens(3))
    assert(container2.electricalResistance.get == Kilohms(2))
    assert(container2.inductance.get == Henry(15))
    assert(container2.magneticFlux.get == Webers(14))
    assert(container2.magneticFluxDensity.get == Teslas(13))
    assert(container2.resistivity.get == OhmMeters(12))

    assert(container2.energy.get == Joules(11))
    assert(
      container2.powerDensity.get == EWattsPerCubicMeter(10))
    assert(container2.energyDensity.get == JoulesPerCubicMeter(9))
    assert(container2.energyAreaDensity.get == JoulesPerSquareMeter(9))
    assert(container2.power.get == Watts(8))
    assert(container2.powerRamp.get == WattsPerHour(7))
    assert(container2.specificEnergy.get == JoulesPerKilogram(6))
    assert(container2.molarEnergy.get == JoulesPerMole(5))

    assert(container2.dataRate.get == BytesPerSecond(7000000))
    assert(container2.information.get == Bytes(100000))

    assert(container2.money.get == USD(1000000))
    assert(container2.employee.get == People(10))
    assert(container2.labor.get == PersonHours(200000))

    assert(container2.areaDensity.get == GramsPerSquareCentimeter(5))
    assert(container2.density.get == KilogramsPerCubicMeter(4))
    assert(container2.mass.get == Grams(3000))
    assert(container2.chemicalAmount.get == Moles(2))
    assert(container2.molarMass.get == KilogramsPerMole(71))
    assert(container2.concentration.get == MolesPerCubicMeter(72))
    assert(container2.catalyticActivity.get == Katals(73))

    assert(container2.acceleration.get == MetersPerSecondSquared(35))
    assert(container2.angularAcceleration.get == DegreesPerSecondSquared(34))
    assert(container2.angularVelocity.get == RadiansPerSecond(34))
    assert(container2.force.get == Newtons(33))
    assert(container2.jerk.get == MetersPerSecondCubed(32))
    assert(container2.massFlow.get == KilogramsPerSecond(31))
    assert(container2.momentum.get == NewtonSeconds(30))
    assert(container2.pressureChange.get == PascalsPerSecond(29))
    assert(container2.pressure.get == Bars(28))
    assert(container2.velocity.get == KilometersPerHour(27))
    assert(container2.volumeFlow.get == CubicMetersPerSecond(26))
    assert(container2.yank.get == NewtonsPerSecond(25))
    assert(container2.surfaceTension.get == NewtonsPerMeter(25))
    assert(container2.viscosity.get == PascalSeconds(25))

    assert(container2.illuminance.get == Lux(24))
    assert(container2.luminance.get == CandelasPerSquareMeter(23))
    assert(container2.luminousEnergy.get == LumenSeconds(22))
    assert(container2.luminousExposure.get == LuxSeconds(21))
    assert(container2.luminousFlux.get == Lumens(20))
    assert(container2.luminousIntensity.get == Candelas(19))

    assert(container2.irradiance.get == ErgsPerSecondPerSquareCentimeter(18))
    assert(container2.radiance.get == WattsPerSteradianPerSquareMeter(17))
    assert(container2.spectralIntensity.get == WattsPerSteradianPerMeter(16))
    assert(
      container2.spectralIrradiance.get == 
        ErgsPerSecondPerSquareCentimeterPerAngstrom(9))
    assert(container2.spectralPower.get == WattsPerMeter(15))
    assert(container2.activity.get == Becquerels(21))
    assert(container2.particleFlux.get == BecquerelsPerSquareMeterSecond(22))
    assert(container2.dose.get == Sieverts(23))
    assert(container2.areaTime.get == SquareMeterSeconds(24))
    assert(container2.absorbedDose.get == Grays(25))

    assert(container2.angle.get == Degrees(14))
    assert(container2.length.get == Meters(13))
    assert(container2.area.get == SquareMeters(12))
    assert(container2.volume.get == CubicMeters(11))
    assert(container2.solidAngle.get == SquareRadians(10))
    assert(container2.specificVolume.get == CubicMetersPerKilogram(11))
    assert(container2.molarVolume.get == CubicMetersPerMole(11))

    assert(container2.temperature.get == Celsius(0.0))
    assert(container2.thermalCapacity.get == JoulesPerKelvin(8))

    assert(container2.time.get == Seconds(7))
    assert(container2.frequency.get == Hertz(6))
    assert(container2.timeSquared.get == SecondsSquared(SDD(5)))
  }
}
