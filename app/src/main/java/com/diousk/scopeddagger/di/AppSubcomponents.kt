package com.diousk.scopeddagger.di

import com.diousk.scopeddagger.di.session.SessionComponent
import dagger.Module

@Module(subcomponents = [SessionComponent::class])
class AppSubcomponents